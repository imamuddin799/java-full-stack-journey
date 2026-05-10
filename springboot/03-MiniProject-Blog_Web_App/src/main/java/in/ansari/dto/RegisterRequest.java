package in.ansari.dto; // Package grouping DTOs used to transfer data between controller, service, and presentation layers

import jakarta.validation.constraints.Email; // Bean Validation annotation to assert a valid email pattern
import jakarta.validation.constraints.NotBlank; // Bean Validation annotation to ensure a string is not null/blank
import jakarta.validation.constraints.Size; // Bean Validation annotation to constrain string length
import lombok.Data; // Lombok convenience annotation to generate getters, setters, equals, hashCode, and toString

/**
 * RegisterRequest is the API-facing Data Transfer Object used when a client
 * registers a new user account.
 *
 * <p>This DTO's responsibilities:
 * - Declare the minimal set of fields required for user registration (name, email, password).
 * - Attach Jakarta Bean Validation constraints to enforce input rules at the controller boundary.
 * - Remain a simple transport object; business rules (email normalization, password hashing,
 *   duplicate checks, sending verification emails) belong to the service layer.
 *
 * Security and design notes:
 * - Password is modeled as String for convenience (aligns with many frameworks). For higher
 *   security requirements consider char[] to allow explicit zeroing of sensitive data.
 * - Validation messages are user-facing; for localization prefer message codes and resource bundles.
 * - DTOs should be validated with @Valid in controller method signatures to ensure constraints run.
 */
@Data // Lombok: generate standard boilerplate (getters, setters, equals, hashCode, toString)
public class RegisterRequest {
    
    @NotBlank(message = "Name is required") // Validation: rejects null, empty, or whitespace-only names
    @Size(min = 3, max = 120, message = "Minimum 3 characters required") // Validation: enforce human-readable name length bounds
    private String name; // The registrant's display name; used for account display and personalization

    @NotBlank(message = "Email Required") // Validation: ensure an email value is present
    @Email(message = "Invalid email format") // Validation: enforce a syntactic email pattern; not proof of deliverability
    @Size(max = 180, message = "Max 180 characters allowed") // Validation: upper bound to protect database columns and storage
    private String email; // User's email address; used as a login principal and for communications (treat as PII)

    @NotBlank(message = "Password Required") // Validation: require a non-empty password value
    @Size(min = 8, max = 100, message = "Password must be at least 8 characters") // Validation: enforce minimum length for basic password strength
    private String password; // Plaintext password received from client; must be hashed and salted before persistence
}
