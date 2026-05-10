package in.ansari.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.ansari.dto.CommentRequest;
import in.ansari.dto.CommentResponse;
import in.ansari.entity.Blog;
import in.ansari.entity.Comment;
import in.ansari.exception.ResourceNotFoundException;
import in.ansari.repository.BlogRepository;
import in.ansari.repository.CommentRepository;
import in.ansari.service.CommentService;

/**
 * Service implementation for comment management.
 *
 * <p>Encapsulates business rules for creating, listing, deleting and paging comments.
 * Responsibilities include: validating existence and active state of the parent blog,
 * mapping between entities and DTOs, enforcing ownership checks for destructive actions,
 * and providing paginated retrieval of comments across a user's blogs.
 *
 * Design notes:
 * - Methods execute inside a transactional boundary to ensure consistency when reading and modifying related entities.
 * - Mapping to CommentResponse centralizes projection logic and prevents controllers from exposing JPA internals.
 * - Deletion performed here is a hard delete; if soft-delete is required, change delete() to set a flag and persist.
 * - Ownership and authorization checks are enforced server-side to prevent client-side bypass.
 */
@Service // Spring stereotype marking this class as a service component
@Transactional // Ensure public methods run within a transactional context
public class CommentServiceImpl implements CommentService {

    // Repository for comment persistence and queries
    private final CommentRepository commentRepository;

    // Repository used to validate and load parent blog entities
    private final BlogRepository blogRepository;

    /**
     * Constructor-injected repositories for testability and immutability.
     *
     * @param commentRepository repository handling Comment persistence and queries
     * @param blogRepository repository handling Blog persistence and queries
     */
    public CommentServiceImpl(CommentRepository commentRepository, BlogRepository blogRepository) {
        this.commentRepository = commentRepository;
        this.blogRepository = blogRepository;
    }

    /**
     * Map a Comment entity to a CommentResponse DTO.
     *
     * <p>Centralizing the mapping keeps controllers and callers simple and ensures
     * consistent fields are returned to API consumers. Mapping reads related blog id
     * only, avoiding leaking the full Blog entity.
     *
     * @param c non-null Comment entity to map
     * @return populated CommentResponse DTO
     */
    private CommentResponse toDto(Comment c) {
        return CommentResponse.builder()
                .id(c.getId()) // comment primary key
                .blogId(c.getBlog().getId()) // denormalized blog id for client convenience
                .name(c.getName()) // commenter display name
                .email(c.getEmail()) // commenter email (PII — handle carefully)
                .commentText(c.getCommentText()) // comment body (must be sanitized before rendering)
                .createdAt(c.getCreatedAt()) // creation timestamp
                .build();
    }

    /**
     * Add a new comment to an active (non-deleted) blog.
     *
     * <p>Steps performed:
     * - Verify the target blog exists and is not soft-deleted.
     * - Build a Comment entity from the request with minimal normalization.
     * - Persist the Comment and return a DTO projection.
     *
     * Security and validation notes:
     * - Controller-level validation should ensure CommentRequest is valid (@Valid).
     * - Request fields are normalized (trim, lowercase email) to reduce duplicates and storage variance.
     * - The loggedInUserId parameter is available for future enhancements (e.g., associating comments to accounts),
     *   but currently not used for anonymous/commenter linking.
     *
     * @param blogId id of the blog to attach the comment to
     * @param request DTO containing name, email, and comment text
     * @param loggedInUserId id of the authenticated user submitting the comment; may be null for anonymous posts
     * @return CommentResponse representing the persisted comment
     * @throws ResourceNotFoundException if the target blog does not exist or is soft-deleted
     */
    @Override
    public CommentResponse addComment(Long blogId, CommentRequest request, Long loggedInUserId) {
        // Ensure the target blog exists and is active
        Blog blog = blogRepository.findByIdAndIsDeletedFalse(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));

        // Build the comment entity with normalized inputs
        Comment comment = Comment.builder()
                .blog(blog) // set relationship
                .name(request.getName().trim()) // trim whitespace from name
                .email(request.getEmail().toLowerCase().trim()) // normalize email case and whitespace
                .commentText(request.getCommentText().trim()) // trim comment text
                .build();

        // Persist and return DTO projection
        return toDto(commentRepository.save(comment));
    }

    /**
     * List comments for a specific blog ordered by creation time ascending.
     *
     * <p>Behavior:
     * - Delegates to the repository which returns results ordered oldest-first.
     * - Maps entities to DTOs to prevent exposing persistence internals to callers.
     *
     * @param blogId id of the blog whose comments should be listed
     * @return ordered list of CommentResponse DTOs for that blog
     */
    @Override
    public List<CommentResponse> listByBlog(Long blogId) {
        return commentRepository.findByBlog_IdOrderByCreatedAtAsc(blogId).stream()
                .map(this::toDto) // map each entity to safe DTO
                .toList(); // collect to list (Java 16+)
    }

    /**
     * Delete a comment only if the provided userId owns the blog containing it.
     *
     * <p>Steps:
     * - Load the comment entity.
     * - Re-check ownership by comparing blog.owner.id with the provided userId.
     * - If authorized, perform a hard delete via the repository.
     *
     * Correctness and security notes:
     * - This method re-evaluates ownership inside the transaction to avoid TOCTOU race conditions.
     * - Throws IllegalArgumentException for missing comment and SecurityException for unauthorized attempts.
     * - If application policy prefers soft-delete, replace commentRepository.delete(...) with a flag update.
     *
     * @param commentId id of the comment to remove
     * @param userId id of the user attempting deletion; must match the blog owner
     * @throws IllegalArgumentException when the comment cannot be found
     * @throws SecurityException when the caller does not own the parent blog
     */
    @Override
    public void deleteCommentIfOwnedBlog(Long commentId, Long userId) {
        // Load comment and fail-fast if absent
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("Comment not found"));

        // Ownership check: only the owner of the parent blog may delete the comment
        if (!comment.getBlog().getUser().getId().equals(userId)) {
            throw new SecurityException("Not allowed to delete this comment");
        }

        // Perform hard delete; consider soft-delete if audit retention is desired
        commentRepository.delete(comment);
    }

    /**
     * Retrieve a paginated page of comments that appear on blogs owned by a specific user.
     *
     * <p>Use-case:
     * - Owner-level moderation or notification inbox where a blog owner reviews comments across all their blogs.
     *
     * Implementation details:
     * - Constructs a Pageable with sorting by createdAt descending so newest comments appear first.
     * - Delegates to repository custom query that navigates Comment -> Blog -> User to filter by owner.
     *
     * @param userId id of the blog owner whose blogs' comments should be returned
     * @param page zero-based page index
     * @param size number of items per page
     * @return Page of Comment entities matching the user's blogs (contains pagination metadata)
     */
    @Override
    public Page<Comment> getCommentsOnUserBlogs(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        return commentRepository.findCommentsOnUserBlogs(userId, pageable);
    }
}
