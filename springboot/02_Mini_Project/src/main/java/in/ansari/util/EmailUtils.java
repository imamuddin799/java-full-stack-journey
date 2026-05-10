package in.ansari.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

/**
 * Utility component for sending email messages using Spring's JavaMailSender.
 * <p>
 * Provides a simple facade to construct and send MIME emails. The helper method
 * supports HTML content by enabling the {@code html} flag when setting the body.
 * </p>
 * <p>
 * Important security and reliability notes:
 * - This utility delegates to the configured {@link JavaMailSender}; ensure mail
 *   server settings (host, port, credentials, TLS/SSL) are correctly configured
 *   in application properties.
 * - The method swallows exceptions and returns a boolean status. For production
 *   use, consider returning richer error information or rethrowing checked
 *   exceptions to enable retry or alerting strategies.
 * </p>
 */

@Component
public class EmailUtils {

	/**
     * Spring-provided mail sender used to create and send MIME messages.
     * <p>
     * Injected by Spring. The implementation must be configured in the application
     * context (for example {@code JavaMailSenderImpl}) with appropriate mail server
     * properties.
     * </p>
     */
	@Autowired
	private JavaMailSender mailSender;
	
	/**
     * Send an email with the given recipient, subject and HTML-capable body.
     * <p>
     * This method creates a {@link MimeMessage}, wraps it with {@link MimeMessageHelper},
     * sets the recipient, subject, and body (HTML enabled), and requests the
     * {@link JavaMailSender} to send it. On success the method returns {@code true}.
     * On failure it logs the exception to standard error and returns {@code false}.
     * </p>
     *
     * @param to the recipient email address; expected to be a valid email string
     * @param subject the subject line for the email
     * @param body the email body; HTML content is allowed and will be rendered by clients
     * @return {@code true} if the mail was sent successfully; {@code false} if an exception occurred
     * @implNote The method currently prints stack traces on failure. Replace with
     *           a proper logging framework and better error handling for production.
     */
	public boolean sendEmail(String to, String subject, String body) {
		boolean isSent = false;
		
		try {
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
			
			helper.setTo(to);
			helper.setSubject(subject);
			helper.setText(body, true);
			
			mailSender.send(mimeMessage);
			
			isSent = true;
		} catch (Exception e) {
			/*
             * Intentionally not rethrowing to preserve boolean API.
             * Current behavior: print stack trace and return false.
             * In production consider logging and handling specific exceptions:
             * - MessagingException (mail formation issues)
             * - MailAuthenticationException (auth issues)
             * - MailSendException (transport issues)
             */
			e.getMessage();
			e.printStackTrace();
		}
		
		return isSent;
	}
}