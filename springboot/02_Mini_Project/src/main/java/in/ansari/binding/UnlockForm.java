package in.ansari.binding;

import lombok.Data;

/**
 * Data Transfer Object used for unlocking or resetting a user account password.
 * <p>
 * Typically used when a user follows an "unlock account" flow that requires a
 * temporary password (often emailed to the user) and submission of a new desired password.
 * This DTO carries the temporary credential along with the new password choice and its confirmation.
 * Validation rules (for example non-null, equality between newPassword and confirmPassword,
 * minimum length, complexity requirements) should be enforced by the controller or service layer.
 * </p>
 */

@Data
public class UnlockForm {
	
	/**
     * Email address of the account to unlock.
     * <p>
     * Expected to be a valid, registered email. Use this value to locate the user record
     * in persistence or to validate that the temporary password applies to this account.
     * </p>
     */
	private String email;

	/**
     * Temporary password or one-time token issued for unlocking the account.
     * <p>
     * This value is typically time-limited and should be validated securely. It must not
     * be logged in plain text and should be invalidated after use.
     * </p>
     */
	private String temporaryPassword;
	
	/**
     * The new password the user wants to set.
     * <p>
     * Apply password policy checks (length, complexity, disallowed patterns) in the
     * service layer before persisting. Ensure the password is hashed using a secure
     * algorithm before storage.
     * </p>
     */
	private String newPassword;
	
	/**
     * Confirmation of the new password to protect against typing errors.
     * <p>
     * The controller or service layer should verify that this matches {@code newPassword}
     * and return a validation error if it does not.
     * </p>
     */
	private String confirmPassword;
}