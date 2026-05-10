package in.ansari.repository; // Package grouping for persistence/repository contracts related to the application's domain

import org.springframework.data.domain.Page; // Spring Data abstraction representing a page of data for pagination responses
import org.springframework.data.domain.Pageable; // Spring Data abstraction that encapsulates pagination parameters (page number, size, sort)
import org.springframework.data.jpa.repository.JpaRepository; // Spring Data JPA base repository providing CRUD, pagination, and sorting
import org.springframework.data.jpa.repository.Query; // Annotation to declare JPQL or native queries on repository methods
import org.springframework.data.repository.query.Param; // Annotation to bind method parameters into @Query placeholders

import in.ansari.entity.Comment; // Domain entity representing a comment persisted in the database

import java.util.List; // Java Collection type for ordered lists
import java.util.Optional; // Java container type that may or may not contain a non-null value

/**
 * Repository contract for Comment entities.
 *
 * <p>Extends Spring Data JPA's JpaRepository to provide basic CRUD operations,
 * pagination, and derived query method support for the Comment entity.
 *
 * Responsibilities:
 * - Expose common query methods used by the service layer (fetch by blog, fetch by id with blog scope).
 * - Provide a pageable query to retrieve comments across all blogs owned by a specific user.
 *
 * Implementation notes:
 * - Method names follow Spring Data's query derivation conventions and are implemented
 *   automatically by the framework at runtime.
 * - The custom JPQL query uses the entity graph to navigate relationships (c.blog.user.id)
 *   which keeps the query at the domain model level and avoids direct joins in SQL.
 * - Security and authorization should be enforced at the service layer; repository methods
 *   only expose data retrieval capabilities.
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Derived query to fetch all comments belonging to a specific blog, sorted by creation time ascending.
    // Spring Data will translate this method name into a JPQL query similar to:
    // SELECT c FROM Comment c WHERE c.blog.id = :blogId ORDER BY c.createdAt ASC
    List<Comment> findByBlog_IdOrderByCreatedAtAsc(Long blogId);

    // Derived query to fetch a comment by its id but scoped to a particular blog id.
    // Returns Optional to clearly model the potential absence of a matching entity.
    // Spring Data translates this into: SELECT c FROM Comment c WHERE c.id = ?1 AND c.blog.id = ?2
    Optional<Comment> findByIdAndBlog_Id(Long id, Long blogId);
    
    // Custom JPQL query to page through comments that belong to any blog owned by a given user.
    // The query navigates the associations from Comment -> Blog -> User to filter by user id.
    // Results are ordered by createdAt descending so newest comments appear first.
    @Query("SELECT c FROM Comment c WHERE c.blog.user.id = :userId ORDER BY c.createdAt DESC")
    Page<Comment> findCommentsOnUserBlogs(@Param("userId") Long userId, Pageable pageable);
}
