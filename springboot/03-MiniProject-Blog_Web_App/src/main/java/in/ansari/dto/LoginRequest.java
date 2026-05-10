package in.ansari.dto;

import jakarta.validation.constraints.Email; // Bean Validation annotation to assert a string adheres to a basic email format
import jakarta.validation.constraints.NotBlank; // Bean Validation annotation to ensure a string is not null and contains non-whitespace characters
import lombok.Data; // Lombok annotation that generates getters, setters, equals, hashCode, and toString methods

/**
 * DTO representing credentials submitted by a client for authentication.
 *
 * <p>This object is used as the API boundary for login endpoints and carries
 * only the minimal information required to authenticate a user: email and password.
 * Validation annotations ensure basic syntactic checks are performed before the
 * request reaches service-layer logic.
 *
 * Security and design notes:
 * - Passwords should be transmitted only over TLS/HTTPS and never logged or
 *   included in exception messages. Treat instances of this DTO as sensitive.
 * - Authentication logic (verification, throttling, session/token issuance)
 *   belongs to the authentication service; this DTO is intentionally dumb and
 *   focused on transport/validation concerns.
 * - Consider using char[] for password handling in security-critical contexts
 *   to allow explicit zeroing of memory; using String is common but retains the
 *   value in memory until GC.
 */
@Data // Lombok: generate getters, setters, equals, hashCode, and toString to reduce boilerplate
public class LoginRequest {

    @NotBlank(message = "Email can not be blank") // Validation: ensures the email field is provided and not only whitespace
    @Email // Validation: verifies the provided string conforms to an email-like pattern
    private String email; // The user's email used as the principal for authentication

    @NotBlank(message = "Password can not be empty") // Validation: ensures a non-empty password is provided
    private String password; // The user's plaintext password supplied for authentication; must be handled securely
}