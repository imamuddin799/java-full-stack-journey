package in.ansari.service; // Package grouping for service-layer interfaces that define business operations for blog management

import java.util.List; // Java collection used to return ordered lists of DTOs

import org.springframework.data.domain.Page; // Spring Data abstraction representing a paginated result set

import in.ansari.dto.BlogRequest; // DTO carrying data required to create or update a Blog
import in.ansari.dto.BlogResponse; // DTO returned to clients representing a Blog with author metadata
import in.ansari.entity.Blog; // JPA entity representing the persisted Blog domain object
import in.ansari.entity.User; // JPA entity representing the persisted User domain object

/**
 * Service contract for blog-related business operations.
 *
 * <p>This interface defines high-level use cases for managing blog posts:
 * creation, update, soft deletion, retrieval, listing, uniqueness checks,
 * searching, and paginated retrieval of a user's published blogs.
 *
 * Design and responsibility notes:
 * - Implementations should enforce authorization, validation, transactional
 *   boundaries, and mapping between DTOs and entities.
 * - Controllers should depend on this interface instead of repositories to
 *   keep web concerns separated from business logic.
 * - Methods returning DTOs (BlogResponse) indicate the service performs mapping
 *   and filters out sensitive internals before returning data to API layers.
 * - Methods returning entities (Page<Blog>) are intended for internal use cases
 *   or admin-style workflows; map to DTOs before sending to external clients.
 */
public interface BlogService { // Service boundary for blog-related business logic and orchestration
    
    /**
     * Create a new blog post owned by the specified user.
     *
     * <p>Implementation responsibilities:
     * - Validate the BlogRequest (or rely on controller-level @Valid).
     * - Enforce business rules such as title uniqueness and content requirements.
     * - Map the DTO to a Blog entity, set ownership to 'owner', persist in a transaction,
     *   and return a BlogResponse DTO suitable for API consumers.
     *
     * @param request DTO containing title, shortDescription, and content
     * @param owner User entity representing the blog author (must be a managed entity or id-validated)
     * @return BlogResponse representing the newly created blog formatted for API responses
     */
    BlogResponse create(BlogRequest request, User owner); // Create operation for new blog posts

    /**
     * Update an existing blog post identified by blogId.
     *
     * <p>Implementation responsibilities:
     * - Verify the blog exists and is not soft-deleted.
     * - Enforce ownership/authorization using the provided owner parameter.
     * - Validate incoming request data and check uniqueness constraints as needed.
     * - Apply changes to the persisted entity within a transaction and return a mapped BlogResponse.
     *
     * @param blogId id of the blog to update
     * @param request DTO carrying updated fields for the blog
     * @param owner User entity of the caller attempting the update; used to enforce authorization
     * @return BlogResponse representing the updated blog suitable for API consumers
     */
    BlogResponse update(Long blogId, BlogRequest request, User owner); // Update operation that modifies an existing blog

    /**
     * Soft-delete a blog post so it is excluded from active listings but retained in storage.
     *
     * <p>Implementation responsibilities:
     * - Verify the blog exists and the caller (owner) has rights to delete it.
     * - Set the entity's isDeleted flag (logical delete) and persist within a transaction.
     * - Decide whether to cascade soft-delete related resources (comments) or leave them intact.
     *
     * @param blogId id of the blog to soft-delete
     * @param owner User entity of the caller attempting the deletion; must be the blog owner
     */
    void softDelete(Long blogId, User owner); // Performs a logical delete (soft-delete) honoring ownership checks

    /**
     * Retrieve an active (not soft-deleted) blog by its identifier.
     *
     * <p>Implementation responsibilities:
     * - Load the blog entity and verify isDeleted is false.
     * - Map the entity to BlogResponse DTO and return it.
     * - Throw a domain-specific exception (e.g., ResourceNotFoundException) if the blog is missing or soft-deleted.
     *
     * @param blogId id of the active blog to retrieve
     * @return BlogResponse representing the active blog
     */
    BlogResponse getActiveById(Long blogId); // Fetch an active blog and return a DTO for presentation

    /**
     * List all active (non-deleted) blogs.
     *
     * <p>Implementation responsibilities:
     * - Query repository for blogs where isDeleted is false, order as required (commonly by createdAt desc).
     * - Map results to BlogResponse DTOs and return a list appropriate for summary views.
     *
     * @return ordered list of BlogResponse DTOs for active blogs
     */
    List<BlogResponse> listActive(); // Retrieve and map all non-deleted blogs for public listing

    /**
     * Check whether a title is unique across blogs, optionally excluding a specific blog id.
     *
     * <p>Typical use-cases:
     * - During creation, call with blogId null or omitted to ensure no existing blog has the same title.
     * - During update, call with the current blog id to allow keeping the same title.
     *
     * @param title title to check for uniqueness
     * @param blogId id of the blog to exclude from the uniqueness check (useful during updates)
     * @return true if the title is unique (no conflicting blog exists), false otherwise
     */
    boolean isTitleUnique(String title, Long blogId); // Utility method for enforcing title uniqueness constraints

    /**
     * Search active blogs using a textual query and return DTOs ranked per application logic.
     *
     * <p>Implementation responsibilities:
     * - Use repository-level search (e.g., weighted LIKE or fulltext) to find matching blogs that are not soft-deleted.
     * - Map results to BlogResponse DTOs and return them in the order defined by the search ranking.
     * - Consider pagination or result limits in the implementation to avoid returning excessively large lists.
     *
     * @param query search text used to match title, shortDescription, and content
     * @return list of BlogResponse DTOs matching the query, ordered by relevance and recency
     */
    List<BlogResponse> search(String query); // Perform application-level search and return mapped DTOs

    /**
     * Retrieve a paginated Page of published (non-deleted) Blog entities owned by a specific user.
     *
     * <p>Design notes:
     * - This method returns entity objects (Page<Blog>) which may be consumed by internal workflows or admin views;
     *   map to DTOs for external clients to avoid exposing JPA internals.
     * - The page and size parameters are zero-based and should be used to construct a Pageable in the implementation.
     * - Implementations should enforce that the requesting user is authorized to view these results where applicable.
     *
     * @param userId id of the blog owner whose published blogs are requested
     * @param page zero-based page index
     * @param size number of items per page
     * @return a Page of Blog entities matching the user's published blogs
     */
    public Page<Blog> getPublishedBlogsByUser(Long userId, int page, int size); // Paginated retrieval of a user's published blogs
}
