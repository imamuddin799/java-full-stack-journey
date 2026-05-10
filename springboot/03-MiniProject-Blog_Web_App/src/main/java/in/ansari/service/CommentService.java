package in.ansari.service;

import java.util.List; // Collection type used to return ordered lists of DTOs and entities

import org.springframework.data.domain.Page; // Spring Data abstraction representing a paginated result set

import in.ansari.dto.CommentRequest; // DTO representing input payload for creating a comment
import in.ansari.dto.CommentResponse; // DTO representing comment data returned to clients
import in.ansari.entity.Comment; // JPA entity representing persisted comment data

/**
 * Service contract for comment-related business operations.
 *
 * <p>This interface defines the core use-cases for comment management within the
 * application: creating comments, listing comments for a blog, retrieving paged
 * comments across a user's blogs, and deleting comments when the current user is
 * the owner of the blog that contains the comment.
 *
 * Design and responsibilities:
 * - Implementations should encapsulate transactional boundaries, validation,
 *   authorization checks, and mapping between DTOs and entities.
 * - Controllers should interact with this interface rather than repositories
 *   directly to keep web layer concerns separated from persistence and business logic.
 * - Methods returning DTOs (CommentResponse) indicate that the service performs
 *   mapping and filters out sensitive entity internals before returning data to callers.
 * - Methods returning entities (Page<Comment>) may be used for internal admin or
 *   processing workflows where domain objects are required. When exposing to API
 *   clients, map entities to DTOs to avoid leaking JPA proxies or lazy-loading behavior.
 *
 * Thread-safety and concurrency notes:
 * - Implementations should be stateless singletons where possible (as typical in Spring)
 *   and handle concurrent access via appropriate transactional isolation and locking strategies.
 * - Deletion methods must re-check ownership and authority inside a transaction to prevent TOCTOU issues.
 */
public interface CommentService { // Service boundary for all comment-specific business logic
    
    /**
     * Adds a new comment to the blog identified by blogId.
     *
     * <p>Expected responsibilities for implementations:
     * - Validate the incoming CommentRequest (or rely on controller-level @Valid).
     * - Verify that the target blog exists and is not soft-deleted.
     * - Optionally enforce rate-limiting, spam checks, or moderation rules.
     * - Persist the Comment entity and map it to CommentResponse for return.
     * - Use loggedInUserId for contextual authorization/audit if the system supports authenticated commenters.
     *
     * @param blogId identifier of the blog to which the comment will be attached
     * @param request DTO containing commenter name, email, and comment body
     * @param loggedInUserId id of the currently authenticated user, if present (may be null for anonymous comments)
     * @return CommentResponse representing the newly created comment suitable for API responses
     */
    CommentResponse addComment(Long blogId, CommentRequest request, Long loggedInUserId); // Create-comment operation signature

    /**
     * Lists comments for a specific blog ordered in a deterministic manner.
     *
     * <p>Implementations should:
     * - Filter out comments associated with soft-deleted blogs if necessary.
     * - Map persisted Comment entities to CommentResponse DTOs to decouple persistence model from API.
     * - Order the returned list (commonly by createdAt ascending so older comments appear first).
     *
     * @param blogId identifier of the blog whose comments should be listed
     * @return ordered list of CommentResponse DTOs for the specified blog
     */
    List<CommentResponse> listByBlog(Long blogId); // Retrieves comments for a blog and maps them to DTOs

    /**
     * Retrieves a paginated page of Comment entities that appear on blogs owned by a user.
     *
     * <p>This method is intended for owner-level views where a user wants to see
     * comments across all their blogs (for moderation or notification purposes).
     *
     * Implementation expectations:
     * - Enforce that the provided userId corresponds to an existing user as needed.
     * - Use the page and size parameters to construct a Pageable in the implementation.
     * - Return a Spring Data Page<Comment> so callers can inspect pagination metadata and content.
     *
     * @param userId id of the blog owner whose blogs' comments are being retrieved
     * @param page zero-based page index to retrieve
     * @param size number of items per page
     * @return a Page of Comment entities matching the user's blogs, ordered per repository/query definition
     */
    public Page<Comment> getCommentsOnUserBlogs(Long userId, int page, int size); // Paginated retrieval for owner's comments across blogs

    /**
     * Deletes the comment identified by commentId if the provided userId owns the blog containing it.
     *
     * <p>Expected behavior for implementations:
     * - Verify that the comment exists and load its associated Blog (and Blog owner).
     * - Confirm that the blog owner id matches the provided userId; if not, throw an authorization exception.
     * - Perform the delete operation within a transaction to avoid race conditions.
     * - Decide whether to perform a physical delete or a logical one depending on application policy.
     *
     * Security and correctness notes:
     * - Always re-check ownership inside the transactional boundary to prevent TOCTOU vulnerabilities.
     * - Map and throw domain-specific exceptions (e.g., ResourceNotFoundException, UnauthorizedException) rather than generic exceptions.
     *
     * @param commentId id of the comment to delete
     * @param userId id of the user attempting the deletion; must be the owner of the blog that contains the comment
     */
    public void deleteCommentIfOwnedBlog(Long commentId, Long userId); // Deletes a comment only when the requesting user owns the parent blog
}
