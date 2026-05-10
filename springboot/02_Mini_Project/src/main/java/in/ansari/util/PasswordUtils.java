package in.ansari.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

/**
 * Utility component that provides password-related helper methods.
 * <p>
 * Currently offers a single method to generate a random password string suitable
 * for initial account setup or temporary credentials. Marked as a Spring
 * {@code @Component} so it can be injected where needed, although the provided
 * method is static and can be used without an instance.
 * </p>
 * <p>
 * Security notes:
 * - The generated password is a simple random sequence drawn from a limited
 *   character set. For production use consider stronger policies (longer length,
 *   inclusion of special characters) and secure distribution mechanisms.
 * - Never log generated passwords or expose them in clear text. Always require
 *   users to change temporary passwords on first use and store only secure hashes.
 * </p>
 */

@Component
public class PasswordUtils {

	/**
     * Generate a random password string.
     * <p>
     * Produces an 8-character password composed of upper-case letters, lower-case
     * letters, and digits using Apache Commons Lang's {@link RandomStringUtils}.
     * The method uses a predefined character set and returns the generated value.
     * </p>
     *
     * @return an 8-character randomly generated password containing letters and digits
     * @implNote To strengthen generated passwords consider increasing the length
     *           and adding punctuation/symbol characters, or use a cryptographically
     *           secure generator if higher entropy is required.
     */
	public static String generateRandomPassword() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz123456890";
		String password = RandomStringUtils.random(8, characters);
		return password;
	}
}