package in.ansari.dto; // Package grouping for DTOs used to transfer data between controller and service layers

import jakarta.validation.constraints.Email; // Bean Validation annotation to assert the string is a well-formed email address
import jakarta.validation.constraints.NotBlank; // Bean Validation annotation to ensure a string is not null and contains non-whitespace characters
import jakarta.validation.constraints.Size; // Bean Validation annotation to constrain the character length of string values
import lombok.Data; // Lombok convenience annotation that generates getters, setters, toString, equals, and hashCode

/**
 * CommentRequest is a simple Data Transfer Object representing the payload
 * expected from clients when submitting a comment for a blog post.
 *
 * <p>This DTO focuses on validation: it uses Jakarta Bean Validation annotations
 * to declare constraints that are enforced at the controller boundary (for
 * example, via @Valid). Keeping validation rules on DTOs ensures that the
 * service and persistence layers receive well-formed data and reduces the risk
 * of invalid state transitions within domain entities.
 *
 * Design considerations:
 * - Fields are intentionally limited to the minimal information required to
 *   create a comment: name, email, and commentText. Additional metadata (e.g.,
 *   userId for authenticated comments, IP address, or moderation flags) should
 *   be added in a separate DTO or handled server-side.
 * - Validation messages are developer-friendly and suitable for direct return
 *   in API error responses. For localization, replace literal messages with
 *   message keys and a message bundle.
 * - Instances of this DTO are mutable because Lombok's @Data generates setters;
 *   if immutability is desired, replace @Data with explicit getters and a
 *   constructor or use an immutable builder pattern.
 */
@Data // Lombok: generates getters, setters, equals, hashCode and toString to simplify boilerplate
public class CommentRequest {

    @NotBlank(message = "Name cannot be empty") // Validation: rejects null, empty, or whitespace-only values for name
    @Size(min = 3, max = 120, message = "Minimum 3 characters required") // Validation: enforces minimum and maximum length for name
    private String name; // Commenter's display name; intended for UI and light identification

    @NotBlank(message = "Email cannot be empty") // Validation: ensures an email value is provided
    @Email(message = "Invalid email format") // Validation: ensures the provided string conforms to a basic email pattern
    @Size(max = 180) // Validation: enforces an upper bound on email length to prevent exceptionally long inputs
    private String email; // Commenter's email address; considered PII and should be handled accordingly

    @NotBlank(message = "Comment cannot be empty") // Validation: ensures commentText is not null, empty, or whitespace-only
    @Size(max = 2000) // Validation: sets a reasonable upper bound on comment size to protect storage and rendering
    private String commentText; // The textual content of the comment; must be sanitized before rendering to prevent XSS
}
