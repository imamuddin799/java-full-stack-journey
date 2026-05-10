package in.ansari.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Domain entity representing a comment left on a blog post.
 *
 * <p>This JPA entity maps to the "comments" table and models the minimal set
 * of fields required to display and moderate comments: a reference to the
 * Blog, commenter name and email, the comment body, and a creation timestamp.
 *
 * Design notes:
 * - The ManyToOne association to Blog uses LAZY fetching to avoid loading the
 *   entire Blog when only comment metadata is needed; callers can explicitly
 *   fetch the blog when required.
 * - The commentText is mapped as TEXT to allow arbitrarily long comment bodies;
 *   columnDefinition ties the schema to databases that support TEXT (e.g., MySQL).
 * - createdAt is populated using a JPA lifecycle callback to centralize audit
 *   timestamp initialization at persist time.
 *
 * Maintenance notes:
 * - Validation, spam filtering, HTML sanitization, and rate-limiting should be
 *   enforced at the service or controller layer before persisting Comment
 *   instances; storing raw user input directly in entities can introduce risks.
 * - If comment moderation or soft-delete is needed later, consider adding
 *   status or isDeleted fields and relevant indexes for querying active comments.
 */
@Entity // Marks this class as a JPA entity managed by the persistence provider
@Table(name = "comments") // Maps this entity to the "comments" table in the database
@Getter // Lombok: generate getters for all fields to expose state safely
@Setter // Lombok: generate setters for all fields; be cautious about mutability when exposing entities
@NoArgsConstructor // Lombok: generate a no-argument constructor required by JPA proxies
@AllArgsConstructor // Lombok: generate an all-arguments constructor for convenience and testing
@Builder // Lombok: enable fluent builder pattern for constructing instances in tests/services
public class Comment {
    @Id // Declares the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use DB identity auto-increment for primary key generation
    private Long id; // Primary key, null before persist and assigned by the database after insert

    @ManyToOne(fetch = FetchType.LAZY) // Many comments can belong to one blog; LAZY to avoid unnecessary joins
    @JoinColumn(name = "blog_id", nullable = false) // Foreign key column name and non-null constraint to enforce referential integrity
    private Blog blog; // Reference to the owning Blog entity; may be a proxy when accessed lazily

    @Column(nullable = false, length = 120) // Maps to a NOT NULL VARCHAR(120) column for the commenter name
    private String name; // Commenter's display name used in UI and basic identification

    @Column(nullable = false, length = 180) // Maps to a NOT NULL VARCHAR(180) column for the email
    private String email; // Commenter's email used for notifications/verification; treat as PII

    @Column(name = "comment_text", nullable = false, columnDefinition = "TEXT") // Persist comment body as TEXT with explicit column name
    private String commentText; // The actual comment content; must be sanitized before rendering to avoid XSS

    @Column(name = "created_at", nullable = false) // Creation timestamp column; NOT NULL to ensure auditability
    private Instant createdAt; // UTC instant recording when the comment was created; set in @PrePersist

    /**
     * JPA lifecycle callback executed before inserting a new Comment row.
     *
     * <p>Initializes createdAt to the current UTC instant to ensure the persisted
     * row has an accurate creation timestamp. Centralizing this logic in a
     * callback reduces duplication and mistakes in service code.
     *
     * Security and correctness notes:
     * - Do not rely solely on client-provided timestamps; server-side assignment
     *   ensures trustworthiness of audit fields.
     * - If the application requires preserving a pre-set createdAt (e.g., for
     *   migrations or test fixtures), add a null-check to avoid overwriting.
     */
    @PrePersist // Instructs JPA to call this method before the entity manager performs an INSERT
    public void prePersist() {
        createdAt = Instant.now(); // Set createdAt to the current UTC instant just before persisting
    }
}
