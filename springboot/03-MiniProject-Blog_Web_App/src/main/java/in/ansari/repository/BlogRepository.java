package in.ansari.repository;

import org.springframework.data.domain.Page; // Spring Data abstraction representing a page of results for pagination
import org.springframework.data.domain.Pageable; // Encapsulates pagination information (page number, size, sort)
import org.springframework.data.jpa.repository.JpaRepository; // Base Spring Data JPA repository providing CRUD and paging operations
import org.springframework.data.jpa.repository.Query; // Allows declaring JPQL queries on repository methods

import in.ansari.entity.Blog; // Domain JPA entity representing the blogs table

import java.util.List; // Java Collection representing an ordered list of elements
import java.util.Optional; // Java container to model an optional presence of a value

/**
 * Repository contract for Blog entities.
 *
 * <p>Extends Spring Data JPA's JpaRepository to inherit standard CRUD, pagination,
 * and sorting behavior for Blog. This interface declares additional derived query
 * methods and a custom JPQL query to support application-specific retrieval needs.
 *
 * Responsibilities:
 * - Provide existence checks used for uniqueness validation.
 * - Expose common reads such as fetching non-deleted blogs and paginated user blogs.
 * - Implement a weighted search that ranks results based on where the query appears
 *   (title > shortDescription > content).
 *
 * Implementation notes:
 * - Method names follow Spring Data query derivation conventions and are implemented
 *   by the framework at runtime; no manual implementation is required.
 * - The custom @Query uses JPQL and string functions; watch out for database-specific
 *   behavior (e.g., full-text search would be preferable for large datasets).
 * - Keep repository methods focused on persistence; authorization, validation, and
 *   business logic should live in the service layer.
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {

    // Derived query method to check whether a blog title already exists.
    // Spring Data derives the query: SELECT COUNT(b) > 0 FROM Blog b WHERE b.title = ?1
    boolean existsByTitle(String title);

    // Derived query method to check whether a short description already exists.
    // Useful for enforcing unique short descriptions at the application level.
    boolean existsByShortDescription(String shortDescription);

    // Derived query that returns all non-deleted blogs ordered by creation time descending.
    // Translates to: SELECT b FROM Blog b WHERE b.isDeleted = false ORDER BY b.createdAt DESC
    List<Blog> findByIsDeletedFalseOrderByCreatedAtDesc();

    // Derived query for fetching a blog by id only when it is not marked deleted.
    // Returns Optional to express possible absence (not found or soft-deleted).
    Optional<Blog> findByIdAndIsDeletedFalse(Long id);

    // Custom JPQL weighted search query.
    // - Filters out soft-deleted blogs (b.isDeleted = false).
    // - Searches title and shortDescription case-insensitively, and content case-sensitively using LIKE.
    // - Orders by a computed weight giving higher priority when the query appears in title (weight 3),
    //   then shortDescription (weight 2), otherwise weight 1 for content matches; ties broken by createdAt desc.
    // Notes:
    // - Uses positional parameter ?1 for the search term.
    // - LOWER() is used to implement case-insensitive matching for title and shortDescription.
    // - For large datasets consider replacing LIKE-based search with a full-text index or external search engine.
    @Query("SELECT b FROM Blog b WHERE b.isDeleted = false AND (" + "LOWER(b.title) LIKE LOWER(CONCAT('%', ?1, '%')) "
            + "OR LOWER(b.shortDescription) LIKE LOWER(CONCAT('%', ?1, '%')) "
            + "OR b.content LIKE CONCAT('%', ?1, '%')) "
            + "ORDER BY CASE WHEN LOWER(b.title) LIKE LOWER(CONCAT('%', ?1, '%')) THEN 3 "
            + "WHEN LOWER(b.shortDescription) LIKE LOWER(CONCAT('%', ?1, '%')) THEN 2 ELSE 1 END DESC, b.createdAt DESC")
    List<Blog> searchWeighted(String query);

    // Derived query returning a pageable slice of blogs for a specific user where isDeleted is false.
    // Spring Data derives: SELECT b FROM Blog b WHERE b.user.id = ?1 AND b.isDeleted = false
    Page<Blog> findByUserIdAndIsDeletedFalse(Long userId, Pageable pageable);

    // Derived query to check whether a title exists for another blog (used during updates to enforce uniqueness).
    // Equivalent to: SELECT COUNT(b) > 0 FROM Blog b WHERE LOWER(b.title) = LOWER(?1) AND b.id <> ?2
    boolean existsByTitleIgnoreCaseAndIdNot(String title, Long id);
}