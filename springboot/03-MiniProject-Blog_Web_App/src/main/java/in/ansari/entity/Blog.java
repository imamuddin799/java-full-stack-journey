package in.ansari.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain entity representing a blog post.
 *
 * <p>This JPA entity maps to the "blogs" table and captures the essential
 * fields required for a typical blog entry: author reference, title,
 * short description, large content body, soft-delete flag, and audit timestamps.
 *
 * Design and maintenance notes:
 * - The entity uses a ManyToOne association to User with LAZY fetching to
 *   avoid unnecessary joins when only blog metadata is needed. Service-layer
 *   code should control eager loading if the User data is required.
 * - Content is mapped as a LOB with an explicit columnDefinition MEDIUMTEXT to
 *   support large HTML or markdown bodies; this ties the mapping to databases
 *   that understand MEDIUMTEXT (e.g., MySQL). Changing DB vendors may require
 *   adjusting columnDefinition.
 * - Audit timestamps are set using JPA lifecycle callbacks (PrePersist and
 *   PreUpdate). This keeps timestamping consistent and centralized.
 * - The isDeleted boolean implements a soft-delete flag; actual removal from
 *   the database should be handled by explicit delete operations or scheduled
 *   purge jobs depending on retention policy.
 *
 * Persistence considerations:
 * - GenerationType.IDENTITY is chosen for primary key auto-increment behavior.
 * - Unique constraints, indexes, and text-search capabilities should be
 *   declared at schema level or via additional JPA annotations if required.
 */
@Entity // Marks this class as a JPA entity managed by the persistence provider
@Table(name = "blogs") // Maps this entity to the "blogs" table in the relational schema
@Getter // Lombok: auto-generate getters for all non-static fields
@Setter // Lombok: auto-generate setters for all non-static fields
@NoArgsConstructor // Lombok: generate a public no-argument constructor required by JPA
@AllArgsConstructor // Lombok: generate a constructor with all fields as parameters
@Builder // Lombok: enable builder pattern for convenient instance construction
public class Blog {
    @Id // Declares the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use DB identity (auto-increment) strategy for PK generation
    private Long id; // Primary key; null before persist, non-null after insert

    @ManyToOne(fetch = FetchType.LAZY) // Many blogs can reference one User; use LAZY loading to avoid unnecessary joins
    @JoinColumn(name = "user_id", nullable = false) // Foreign key column in blogs table referencing users table; not nullable to enforce ownership
    private User user; // Reference to the blog author; a proxied/managed association when fetched lazily

    @Column(nullable = false, length = 200) // Maps to a VARCHAR(200) NOT NULL column for the title
    private String title; // Short descriptive title used for display and indexing

    @Column(name = "short_description", nullable = false, length = 300) // Column explicitly named to separate it from any default naming conventions
    private String shortDescription; // Brief summary of the blog content used in lists and previews

    @Lob // Indicates that content should be treated as a large object (LOB) by JPA
    @Column(nullable = false, columnDefinition = "MEDIUMTEXT") // Persist as MEDIUMTEXT to support larger content than typical VARCHAR
    private String content; // The main body of the blog; can contain HTML/markdown and may be large

    @Column(name = "is_deleted", nullable = false) // Soft-delete flag persisted as a boolean column
    private boolean isDeleted; // When true, the blog is considered deleted for application purposes but remains in the DB

    @Column(name = "created_at", nullable = false) // Auditable creation timestamp; non-null to ensure every row has a creation time
    private Instant createdAt; // UTC timestamp recorded when the blog is first created

    @Column(name = "updated_at") // Optional last-modified timestamp; nullable for newly-created entities that haven't been updated
    private Instant updatedAt; // UTC timestamp recorded when the blog is updated; maintained by lifecycle hook
    
    /**
     * JPA lifecycle callback executed before inserting a new Blog row.
     *
     * <p>This method centralizes creation timestamp initialization so callers
     * don't need to set createdAt manually. It ensures createdAt reflects the
     * instant the entity manager performed the persist operation.
     *
     * Implementation note:
     * - Uses Instant.now() to record a timezone-agnostic UTC instant.
     * - If createdAt were already set before persist, this implementation
     *   currently overwrites it; if preservation is required, add a null-check.
     */
    @PrePersist // Run this method before the persistence provider issues an INSERT
    public void prePersist() {
        createdAt = Instant.now(); // Assign the current UTC instant to createdAt immediately before the insert
    }

    /**
     * JPA lifecycle callback executed before updating an existing Blog row.
     *
     * <p>This method updates the updatedAt timestamp to the current instant
     * whenever the entity is about to be merged/updated. It supports optimistic
     * concurrency strategies and simple audit trails.
     *
     * Implementation note:
     * - This callback runs on any update operation; if you want to avoid
     *   changing updatedAt for certain internal changes, guard the assignment
     *   with conditional checks based on the change set.
     */
    @PreUpdate // Run this method before the persistence provider issues an UPDATE
    public void preUpdate() {
        updatedAt = Instant.now(); // Assign the current UTC instant to updatedAt immediately before the update
    }
}
