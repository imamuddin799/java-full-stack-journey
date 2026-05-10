package in.ansari.service;

import in.ansari.binding.LoginForm;
import in.ansari.binding.SignUpForm;
import in.ansari.binding.UnlockForm;


/**
 * Service contract for user-related operations such as registration, authentication,
 * account unlocking, and password recovery.
 * <p>
 * Implementations of this interface encapsulate business logic for managing user
 * lifecycle actions and coordinate with repositories, email utilities, and security
 * components. Methods return simple status indicators or tokens suitable for
 * controller-level consumption; callers should handle nulls and boolean results
 * according to application flow (for example, converting them to HTTP responses).
 * </p>
 */
public interface UserService {

	/**
     * Register a new user using data supplied in the sign-up form.
     * <p>
     * Typical responsibilities of an implementation:
     * - validate input (uniqueness of email/username, phone format)
     * - create and persist a new user record (hashing credentials appropriately)
     * - send verification or unlock emails if required
     * - enforce business constraints (for example, initial accountStatus)
     * </p>
     *
     * @param form the {@link SignUpForm} containing username, email and phone number; must not be {@code null}
     * @return {@code true} if registration succeeded and any required side-effects (persistence, notification) were performed; {@code false} on validation failure or other recoverable errors
     * @throws RuntimeException for unexpected failures; implementations may choose more specific exceptions
     */
	public boolean signup(SignUpForm form);
	
	/**
     * Unlock a user's account using a temporary password and set a new password.
     * <p>
     * Expected flow:
     * - validate that {@code temporaryPassword} matches the one issued for the {@code email}
     * - validate password policy and that {@code newPassword} and {@code confirmPassword} match
     * - update the persisted credential (store hashed) and set account status to unlocked/active
     * - invalidate the temporary credential
     * </p>
     *
     * @param form the {@link UnlockForm} containing email, temporaryPassword, newPassword and confirmPassword; must not be {@code null}
     * @return {@code true} if the account was successfully unlocked and the password updated; {@code false} if validation fails or the temporary credential is invalid
     * @throws RuntimeException for unexpected persistence or infrastructure errors
     */
	public boolean unlockAccount(UnlockForm form);
	
	/**
     * Authenticate a user using submitted credentials.
     * <p>
     * Implementations should validate credentials securely (compare supplied password
     * against a stored hash) and return a representation of authentication state.
     * Common return values:
     * - a non-null token (for example a JWT) on successful authentication
     * - descriptive codes or messages for failure states (for example "INVALID_CREDENTIALS",
     *   "ACCOUNT_LOCKED"), or {@code null} depending on system design
     * </p>
     *
     * @param form the {@link LoginForm} containing userEmail and password; must not be {@code null}
     * @return a {@link String} token or status message; non-null typically indicates success (token) while {@code null} or specific messages indicate failure depending on implementation
     * @throws RuntimeException for unexpected errors during authentication
     */
	public String login(LoginForm form);
	
	/**
     * Initiate the forgot-password flow for a user identified by email.
     * <p>
     * Typical responsibilities:
     * - verify that the email corresponds to a registered user
     * - generate a secure temporary credential or reset token
     * - persist the token and its expiry, and send a recovery email to the user
     * - return a boolean indicating whether the process was started (do not reveal
     *   whether the email exists in responses if that would leak user existence)
     * </p>
     *
     * @param email the email address for which to initiate password recovery; must not be {@code null}
     * @return {@code true} if the recovery process was initiated successfully (token generated and email queued); {@code false} on validation failure or if the operation could not be completed
     * @throws RuntimeException for unexpected infrastructure errors (mail server, persistence)
     */
	public boolean forgotPassword(String email);
}