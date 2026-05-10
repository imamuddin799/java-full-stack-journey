package in.ansari.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.ansari.dto.BlogRequest;
import in.ansari.dto.BlogResponse;
import in.ansari.entity.Blog;
import in.ansari.entity.User;
import in.ansari.exception.ResourceNotFoundException;
import in.ansari.exception.UnauthorizedException;
import in.ansari.repository.BlogRepository;
import in.ansari.service.BlogService;

import java.time.Instant;
import java.util.List;

/**
 * Service implementation for blog management.
 *
 * <p>Implements business operations for creating, updating, soft-deleting,
 * retrieving and searching blog posts. This class encapsulates transactional
 * boundaries, authorization checks (owner-only operations), DTO mapping, and
 * basic normalization of incoming data.
 *
 * Design notes:
 * - Methods return DTOs (BlogResponse) for API-facing operations to avoid exposing
 *   JPA internals to controllers. The paginated retrieval method returns entities
 *   (Page<Blog>) for internal/admin usage where domain objects are required.
 * - Ownership checks are enforced inside transactional boundaries to avoid TOCTOU issues.
 * - Soft delete is implemented by toggling the isDeleted flag and updating updatedAt.
 */
@Service // Spring stereotype marking this as a service component
@Transactional // Ensures public methods execute within a transactional context
public class BlogServiceImpl implements BlogService {

    private final BlogRepository blogRepository; // Repository used for persistence operations

    // Constructor injection for the repository dependency (testable and immutable)
    public BlogServiceImpl(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    /**
     * Map a Blog entity to a BlogResponse DTO.
     *
     * <p>Centralizing mapping here keeps controllers and other callers simple and
     * ensures consistent projection of fields returned to API consumers.
     *
     * @param b Blog entity to map; expected to be non-null and attached or detached
     * @return BlogResponse DTO populated from the entity
     */
    private BlogResponse toDto(Blog b) {
        return BlogResponse.builder()
                .id(b.getId()) // blog primary key
                .userId(b.getUser().getId()) // owner's id denormalized for clients
                .userName(b.getUser().getName()) // owner's display name
                .title(b.getTitle()) // title text
                .shortDescription(b.getShortDescription()) // short summary
                .content(b.getContent()) // full content
                .createdAt(b.getCreatedAt()) // creation timestamp
                .updatedAt(b.getUpdatedAt()) // last updated timestamp, may be null
                .build();
    }

    /**
     * Create a new Blog owned by the provided user.
     *
     * <p>Normalizes title and shortDescription by trimming; sets createdAt and isDeleted.
     * Business constraints such as title uniqueness should be validated by caller or added here.
     *
     * @param request BlogRequest carrying title, shortDescription and content
     * @param owner   User entity representing the blog owner (should be a managed or validated entity)
     * @return BlogResponse DTO for the newly created blog
     */
    @Override
    public BlogResponse create(BlogRequest request, User owner) {
        Blog blog = Blog.builder()
                .user(owner) // set the owner relationship
                .title(request.getTitle().trim()) // normalize title
                .shortDescription(request.getShortDescription().trim()) // normalize short description
                .content(request.getContent()) // content may include markup; validation/sanitization is caller's responsibility
                .createdAt(Instant.now()) // set creation timestamp in UTC instant
                .isDeleted(false) // new blog is active by default
                .build();

        // Persist and map to DTO
        return toDto(blogRepository.save(blog));
    }

    /**
     * Update an existing active blog. Only the owner may update.
     *
     * <p>Checks for existence and isDeleted flag, enforces ownership, applies changes,
     * updates the updatedAt timestamp, and persists the entity.
     *
     * @param blogId  id of the blog to update
     * @param request DTO carrying new values
     * @param owner   User entity attempting the update; used for authorization
     * @return BlogResponse DTO for the updated blog
     * @throws ResourceNotFoundException if the blog does not exist or is soft-deleted
     * @throws UnauthorizedException     if the caller is not the owner of the blog
     */
    @Override
    public BlogResponse update(Long blogId, BlogRequest request, User owner) {
        // Load the blog only if not soft-deleted; otherwise treat as not found
        Blog blog = blogRepository.findByIdAndIsDeletedFalse(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));

        // Ownership check: only the owner may edit
        if (!blog.getUser().getId().equals(owner.getId())) {
            throw new UnauthorizedException("Only the owner can edit this blog");
        }

        // Apply updates with minimal normalization
        blog.setTitle(request.getTitle().trim());
        blog.setShortDescription(request.getShortDescription().trim());
        blog.setContent(request.getContent());
        blog.setUpdatedAt(Instant.now()); // record modification time

        // Persist changes and return mapped DTO
        return toDto(blogRepository.save(blog));
    }

    /**
     * Soft-delete a blog (mark as deleted) if the caller is the owner.
     *
     * <p>Soft delete preserves the record for auditing/history while excluding it
     * from active listings. The method re-checks ownership inside the transaction.
     *
     * @param blogId id of the blog to soft-delete
     * @param owner  User entity attempting the delete; must be the blog owner
     * @throws ResourceNotFoundException if the blog does not exist or is already soft-deleted
     * @throws UnauthorizedException     if the caller does not own the blog
     */
    @Override
    public void softDelete(Long blogId, User owner) {
        Blog blog = blogRepository.findByIdAndIsDeletedFalse(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));

        // Verify ownership before changing state
        if (!blog.getUser().getId().equals(owner.getId())) {
            throw new UnauthorizedException("Only the owner can delete this blog");
        }

        // Logical deletion and timestamp update
        blog.setDeleted(true);
        blog.setUpdatedAt(Instant.now());

        // Persist the soft-delete
        blogRepository.save(blog);
    }

    /**
     * Retrieve an active (non-deleted) blog by id and return a DTO.
     *
     * @param blogId id of the blog to retrieve
     * @return BlogResponse DTO for the active blog
     * @throws ResourceNotFoundException if the blog does not exist or is soft-deleted
     */
    @Override
    public BlogResponse getActiveById(Long blogId) {
        Blog b = blogRepository.findByIdAndIsDeletedFalse(blogId)
                .orElseThrow(() -> new ResourceNotFoundException("Blog not found"));
        return toDto(b);
    }

    /**
     * List all active blogs ordered by creation time descending, mapped to DTOs.
     *
     * @return ordered list of BlogResponse DTOs for active blogs
     */
    @Override
    public List<BlogResponse> listActive() {
        return blogRepository.findByIsDeletedFalseOrderByCreatedAtDesc().stream()
                .map(this::toDto) // map each entity to DTO
                .toList(); // collect to an immutable list (Java 16+); use collect(Collectors.toList()) if older JDK
    }

    /**
     * Check whether a title is unique. When blogId is provided, the method allows
     * the title of that blog to remain the same (used during updates).
     *
     * @param title  title to check
     * @param blogId optional blog id to exclude from the uniqueness check
     * @return true when the title is unique (no conflicting blog exists), false otherwise
     */
    @Override
    public boolean isTitleUnique(String title, Long blogId) {
        boolean exists;
        if (blogId != null) {
            // During update: exclude the current blog from the check
            exists = blogRepository.existsByTitleIgnoreCaseAndIdNot(title.trim(), blogId);
        } else {
            // During create: simply check existence by title
            exists = blogRepository.existsByTitle(title.trim());
        }
        return !exists; // invert to return uniqueness
    }

    /**
     * Perform a weighted search over active blogs and return mapped DTOs.
     *
     * <p>The repository's searchWeighted applies ranking (title > shortDescription > content).
     * Trims the incoming query to avoid accidental whitespace-only matches.
     *
     * @param query search text used to match title, shortDescription and content
     * @return list of BlogResponse DTOs ordered by relevance and recency
     */
    @Override
    public List<BlogResponse> search(String query) {
        return blogRepository.searchWeighted(query.trim()).stream()
                .map(this::toDto)
                .toList();
    }

    /**
     * Retrieve a pageable list of published (non-deleted) Blog entities owned by a specific user.
     *
     * <p>This method returns entity objects (Page<Blog>) intentionally for internal or
     * administrative workflows that may need domain-level operations. Controllers should
     * map entities to DTOs before exposing them to external clients.
     *
     * @param userId id of the blog owner
     * @param page   zero-based page index
     * @param size   number of items per page
     * @return Page of Blog entities for the specified user ordered by createdAt descending
     */
    @Override
    public Page<Blog> getPublishedBlogsByUser(Long userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending()); // create pageable with sorting
        return blogRepository.findByUserIdAndIsDeletedFalse(userId, pageable); // delegate to repository
    }

}
