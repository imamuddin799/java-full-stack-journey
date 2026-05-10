package in.ansari.binding;

import lombok.Data;

/**
 * Data Transfer Object representing user credentials submitted during login.
 * <p>
 * Intended for use by authentication endpoints to capture the user's email and
 * password provided through a login form or API request. This class is a simple
 * carrier of credential data and does not perform validation or authentication itself.
 * Validation (for example non-null, email format) and authentication logic should
 * be implemented in the controller or service layer, and passwords should be handled
 * securely (hashed/stored safely) when persisted.
 * </p>
 */
@Data
public class LoginForm {

	/**
     * Email address provided by the user for authentication.
     * <p>
     * Expected to be a valid email format. Consumers should validate this field
     * (for example using Bean Validation) before attempting authentication.
     * This value may be used as the principal/username depending on the application's
     * authentication strategy.
     * </p>
     */
	private String userEmail;
	
	/**
     * Password provided by the user for authentication.
     * <p>
     * This should contain the raw password submitted by the user; it must never be
     * logged or stored in plaintext. Compare the provided value against a securely
     * stored password hash using a purpose-built authentication component (for example
     * Spring Security) rather than handling raw comparisons in application code.
     * </p>
     */
	private String password;
}