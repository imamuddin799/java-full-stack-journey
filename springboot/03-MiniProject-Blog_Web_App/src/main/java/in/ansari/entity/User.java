package in.ansari.entity;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an application User persisted to the database.
 *
 * <p>This JPA entity maps to the "users" table and models core user account
 * properties used for authentication and audit. The class relies on Jakarta
 * Persistence annotations for ORM mapping and lifecycle hooks, and Lombok
 * annotations to generate boilerplate (getters, setters, constructors, builder).
 *
 * Key responsibilities:
 * - Define persistent fields (id, name, email, passwordHash, createdAt).
 * - Provide a JPA lifecycle hook to populate creation timestamp before insert.
 *
 * Notes for maintainers:
 * - Fields are intentionally simple value objects; any business rules (e.g.,
 *   password hashing, email normalization, validation) should be applied by
 *   service-layer or at the DTO/validation boundary, not inside this entity.
 * - The entity uses GenerationType.IDENTITY which is appropriate when the
 *   underlying database provides an auto-increment primary key. Changing the
 *   strategy may require migration and repository adjustments.
 */
@Entity // Marks this class as a JPA entity to be managed by the persistence provider
@Table(name = "users") // Maps the entity to the "users" table in the database
@Getter // Lombok: generates public getters for all non-static fields
@Setter // Lombok: generates public setters for all non-static fields
@NoArgsConstructor // Lombok: generates a public no-args constructor (required by JPA)
@AllArgsConstructor // Lombok: generates a public all-args constructor
@Builder // Lombok: enables builder pattern for convenient immutable-like construction
public class User {
    @Id // Denotes the primary key of the entity
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Primary key generation strategy using DB identity/auto-increment
    private Long id; // Unique identifier for the user, nullable before persistence, non-null after insert

    @Column(nullable = false, length = 120) // Maps to a non-nullable varchar(120) column
    private String name; // Human-readable name for the user; used for display and UX

    @Column(nullable = false, unique = true, length = 180) // Non-nullable, unique constraint to enforce email uniqueness
    private String email; // User's email address; used as a canonical identifier for login/communications

    @Column(name = "password_hash", nullable = false, length = 100) // Maps to 'password_hash' column; stores hashed password
    private String passwordHash; // Stored representation of the user's password (must be a secure hash; never store plaintext)

    @Column(name = "created_at", nullable = false) // Persists creation timestamp; non-nullable to guarantee auditability
    private Instant createdAt; // Timestamp (UTC) when the entity was first persisted; set via lifecycle hook
    
    /**
     * JPA lifecycle callback invoked before the entity is persisted.
     *
     * <p>This method ensures the createdAt timestamp is initialized immediately
     * prior to INSERT. Using a PrePersist hook centralizes timestamp logic so
     * callers and services do not need to remember to set it explicitly.
     *
     * Implementation notes:
     * - Instant.now() yields a machine-readable UTC timestamp suitable for
     *   storage and comparisons. If application-level timezone conversions are
     *   required, they should happen at the presentation layer.
     * - This hook will not overwrite an existing createdAt value if it has
     *   been set earlier; if such behavior is desired, add a guard or explicit
     *   overwrite logic.
     *
     * Lifecycle behavior:
     * - Called only once by the persistence provider before the SQL INSERT.
     * - Not invoked for updates.
     */
    @PrePersist // Instructs JPA to call this method before the entity manager performs an insert
    public void prePersist() {
        createdAt = Instant.now(); // Set createdAt to current UTC instant immediately before persisting
    }
}
