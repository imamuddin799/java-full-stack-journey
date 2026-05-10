package in.ansari.dto; // Package for Data Transfer Objects used to move data between layers

import lombok.Builder; // Lombok annotation to generate a builder for this DTO
import lombok.Data; // Lombok annotation to generate getters, setters, toString, equals, and hashCode

import java.time.Instant; // Java time type representing an instantaneous point on the timeline

/**
 * DTO returned by the API representing a Blog with author metadata and audit timestamps.
 *
 * <p>This response object is shaped for presentation and transport; it intentionally
 * separates concerns from the persistence entity (in.ansari.entity.Blog). Fields
 * contain minimal derived or joined information (e.g., userId and userName) that
 * controllers or service-layer mappers populate from domain objects.
 *
 * Design notes:
 * - Use DTOs like this to avoid exposing internal entity structure, lazy-loading
 *   proxies, or JPA-specific annotations to API consumers.
 * - Lombok's @Data provides standard value semantics and mutability; if immutability
 *   is preferred, consider removing setters or using a dedicated immutable builder.
 * - Instant fields are timezone-agnostic and represent UTC instants; presentation
 *   layers should format them to the desired timezone/locale.
 */
@Data // Lombok: generate getters, setters, equals, hashCode and toString for all fields
@Builder // Lombok: provide a fluent builder API to construct instances of BlogResponse
public class BlogResponse {
    
    private Long id; // Unique identifier of the blog post (mirrors blog entity id)
    private Long userId; // Identifier of the user/author who created the blog (denormalized for client convenience)
    private String userName; // Display name of the blog author; populated by mapper/service
    private String title; // Title of the blog post intended for display and SEO
    private String shortDescription; // Short summary shown in lists or previews
    private String content; // Full content/body of the blog; may be HTML or markdown depending on app conventions
    private Instant createdAt; // UTC instant when the blog was created; useful for sorting and display
    private Instant updatedAt; // UTC instant when the blog was last updated; nullable if never updated
}