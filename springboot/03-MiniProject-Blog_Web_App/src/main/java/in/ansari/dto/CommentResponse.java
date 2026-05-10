package in.ansari.dto; // Package for Data Transfer Objects used to transport data between controller/service layers and API clients

import lombok.Builder; // Lombok annotation to generate a fluent builder API for constructing instances of this DTO
import lombok.Data; // Lombok annotation to generate getters, setters, equals, hashCode, and toString

import java.time.Instant; // Java time class representing an instantaneous point on the timeline, used for timestamps

/**
 * Data Transfer Object returned by the API representing a Comment.
 *
 * <p>This DTO is intended for presentation and transport only. It decouples
 * API responses from persistence entities (in.ansari.entity.Comment) to avoid
 * exposing internal JPA implementation details, lazy proxies, or domain-only
 * fields to clients.
 *
 * Design and usage notes:
 * - Fields such as blogId and createdAt are denormalized or derived values that
 *   should be populated by a mapper in the service or controller layer.
 * - Instant is used to represent timestamps in a timezone-agnostic way; the
 *   presentation layer should format these instants into human-friendly strings
 *   with the appropriate timezone/locale.
 * - Lombok's @Data produces mutable DTOs; if immutability is desired, consider
 *   removing setters or switching to an immutable value object pattern.
 * - The builder provided by Lombok simplifies tests and mapping code when not
 *   all fields are available at construction time.
 */
@Data // Lombok: generates standard boilerplate (getters/setters/etc.) for this DTO
@Builder // Lombok: generates a builder() method and fluent builder for convenient construction
public class CommentResponse {
    
    private Long id; // Unique identifier for the comment (mirrors the entity primary key)
    private Long blogId; // Identifier of the blog post this comment belongs to; denormalized for client convenience
    private String name; // Display name of the commenter; intended for UI presentation
    private String email; // Commenter's email; included here for transparency or moderation UIs (treat as PII)
    private String commentText; // The full text of the comment; must be sanitized before rendering to clients
    private Instant createdAt; // UTC instant when the comment was created; useful for sorting and display
}