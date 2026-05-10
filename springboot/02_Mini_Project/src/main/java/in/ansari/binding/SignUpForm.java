package in.ansari.binding;

import lombok.Data;

/**
 * Data Transfer Object for user registration input.
 * <p>
 * Carries minimal information required to create a new user account.
 * Used by controller and service layers to receive sign-up requests from the UI or API.
 * Validation such as non-null checks, email format, and phone number constraints
 * should be applied by the consuming layer (for example via Bean Validation).
 * </p>
 */
@Data
public class SignUpForm {

	/**
     * Chosen username for the new account.
     * <p>
     * Should be validated for uniqueness and allowed characters by the service layer
     * before creating a corresponding UserDetailsEntity. May be used as a display
     * name or login identifier depending on application rules.
     * </p>
     */
	private String username;
	
	/**
     * Email address for the user.
     * <p>
     * Expected to be a valid email string. Validate format and uniqueness before
     * persisting. This field is commonly used as the principal for authentication.
     * </p>
     */
	private String userEmail;
	
	/**
     * Contact phone number for the user.
     * <p>
     * Stored as a {@link Long} here; if international formats or leading zeros are
     * required consider using {@link String} instead. Validate length and format
     * in the controller or service layer prior to persistence.
     * </p>
     */
	private Long userPhoneNumber;
}