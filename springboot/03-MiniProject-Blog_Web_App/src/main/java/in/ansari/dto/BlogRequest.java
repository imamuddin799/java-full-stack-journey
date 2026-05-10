package in.ansari.dto; // Package grouping for DTOs shared between controller and service layers

import jakarta.validation.constraints.NotBlank; // Bean Validation annotation to assert a string is not null and not blank
import jakarta.validation.constraints.Size; // Bean Validation annotation to constrain the length of string values
import lombok.Data; // Lombok shortcut to generate getters, setters, toString, equals, and hashCode

/**
 * Data Transfer Object that carries data required to create or update a Blog.
 *
 * <p>This class is intentionally simple and focused on validation concerns only.
 * It is used at the API boundary (controllers) to encapsulate incoming payloads
 * and to trigger Bean Validation semantics before the data reaches the service
 * or persistence layers.
 *
 * Design notes:
 * - Use DTOs to separate transport-level concerns (validation, serialization)
 *   from persistence models (entities). This prevents accidental persistence of
 *   transient or unvalidated fields and makes input validation explicit.
 * - Lombok's @Data is used to reduce boilerplate; be aware it generates
 *   setters which make instances mutable — prefer creating defensive copies
 *   when passing to other layers if immutability is required.
 * - Validation annotations here enforce basic constraints; complex validation
 *   (e.g., content length by bytes, HTML sanitization) should be handled in
 *   custom validators or service layer logic.
 */
@Data // Lombok: generates getters, setters, equals, hashCode, and toString for all fields
public class BlogRequest {

    @NotBlank(message = "Title is required") // Fail validation if title is null or blank (after trimming)
    @Size(max = 200, message = "Title must not exceed 200 characters") // Enforce maximum length at the validation layer
    private String title; // The blog title provided by the client; intended for display and indexing

    @NotBlank(message = "Short description is required") // Require a non-empty short description for previews and meta
    @Size(max = 300) // Duplicate-size annotation present in original code; kept as-is to avoid logic changes
    @Size(max = 300, message = "Short description must not exceed 300 characters") // Explicit message for the max-length constraint
    private String shortDescription; // Brief summary used in list views and SEO meta descriptions

    @NotBlank(message = "Content cannot be empty") // Ensure the main content is provided; prevents storing empty posts
    private String content; // The main body of the blog (HTML/markdown); must be sanitized before rendering or persistence
}