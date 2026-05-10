package com.ansari.utils;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import jakarta.mail.internet.MimeMessage;

/**
 * ============================================================
 *  CLASS NAME: EmailUtils
 * ============================================================
 *  DESCRIPTION:
 *  The {@code EmailUtils} class is a Spring-managed utility component
 *  responsible for handling all email-sending operations within the application.
 *  <p>
 *  It leverages Spring’s {@link JavaMailSender} abstraction, which internally
 *  uses the JavaMail API to send MIME (Multipurpose Internet Mail Extensions)
 *  messages — capable of transmitting not only text but also attachments such as
 *  Excel or PDF reports.
 *  </p>
 *  
 *  <h3>Primary Responsibilities:</h3>
 *  <ul>
 *      <li>Build and send rich HTML-based email messages.</li>
 *      <li>Attach dynamically generated report files to outgoing messages.</li>
 *      <li>Provide a reusable utility method that can be invoked from services
 *          such as {@link com.ansari.service.ReportServiceImpl}.</li>
 *  </ul>
 *
 *  <h3>Technical Highlights:</h3>
 *  <ul>
 *      <li>Uses {@link MimeMessageHelper} for easier construction of
 *          multipart (attachment-enabled) email messages.</li>
 *      <li>Supports HTML-formatted content by enabling the <code>html</code> flag.</li>
 *      <li>Ensures email sending errors are logged without halting application flow.</li>
 *  </ul>
 *
 *  <p><b>Author:</b> Imamuddin Ansari</p>
 *  <p><b>Version:</b> 1.0</p>
 *  <p><b>Since:</b> 2025-11-02</p>
 */

@Component
public class EmailUtils {

	/** 
     * Injected Spring component for sending MIME-based emails.
     * <p>
     * The {@link JavaMailSender} interface abstracts the complexity of JavaMail API,
     * providing simple methods to compose and send emails. Configuration details
     * such as host, port, username, and password are defined in
     * <code>application.properties</code>.
     * </p>
     */
	@Autowired
	private JavaMailSender mailSender;
	
	/**
     * Sends an email with an optional file attachment.
     * <p>
     * This method constructs a MIME message that can include HTML-formatted
     * body content and one or more attachments. In this application, it is used
     * to send either Excel or PDF reports generated dynamically from citizen plan data.
     * </p>
     *
     * <h4>Execution Flow:</h4>
     * <ol>
     *     <li>Create a {@link MimeMessage} instance using {@link JavaMailSender}.</li>
     *     <li>Wrap it in a {@link MimeMessageHelper} to simplify multipart message handling.</li>
     *     <li>Set the subject, recipient, and email body.</li>
     *     <li>If a file is provided, attach it to the email using the filename parameter.</li>
     *     <li>Send the message via the configured SMTP server (e.g., Gmail SMTP).</li>
     * </ol>
     *
     * @param subject   the subject line of the email.
     * @param body      the main content of the email (can include HTML markup).
     * @param to        the recipient email address.
     * @param filename  the display name of the attached file (as seen by the recipient).
     * @param file      the actual {@link File} object to attach (e.g., a PDF or Excel file).
     * @return {@code true} if the email was successfully sent, or {@code false} if any exception occurred.
     */
	public boolean sendEmail(String subject, String body, String to, String filename, File file) {
		try {
            // Create a MIME message capable of handling attachments
			MimeMessage mimeMessage = mailSender.createMimeMessage();
			
            // Helper class for building multipart email messages
			MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
			
            // Set basic email details
			helper.setSubject(subject);
			helper.setText(body, true); // 'true' enables HTML body content
			helper.setTo(to);
			helper.addAttachment(filename, file);
			
			// Send the email
			mailSender.send(mimeMessage);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}