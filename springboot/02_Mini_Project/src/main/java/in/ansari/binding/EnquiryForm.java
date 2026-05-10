package in.ansari.binding;

import lombok.Data;

/**
 * Data Transfer Object representing the form data for a student enquiry.
 * <p>
 * Used to transfer enquiry details between the presentation layer and service
 * layer (for example, when creating, updating, or viewing an enquiry).
 * Fields are simple strings and identifiers; validation and conversion (for example
 * phone number formatting or ID presence checks) should be applied in service
 * or controller layers as needed.
 * </p>
 */
@Data
public class EnquiryForm {
	
	/**
     * Unique identifier of the enquiry.
     * <p>
     * When present, indicates an existing enquiry being edited; when {@code null},
     * indicates a new enquiry to be created.
     * </p>
     */
	private Integer enquiryId;

	/**
     * Full name of the student making the enquiry.
     * <p>
     * Intended for display and contact purposes. Consider applying non-empty and
     * length validation at the controller or service level.
     * </p>
     */
	private String studentName;
	
	/**
     * Contact phone number for the student.
     * <p>
     * Stored as a string to preserve leading zeros and formatting. Validate format
     * (for example E.164 or local rules) before saving or using in external systems.
     * </p>
     */
	private String studentPhoneNumber;
	
	/**
     * Preferred class mode requested by the student.
     * <p>
     * Typical values might include "Online", "Classmode", or "Hybrid". Consider
     * using a controlled vocabulary or enum if the set of modes is fixed.
     * </p>
     */
	private String classMode;
	
	/**
     * Name of the course the student is interested in.
     * <p>
     * This is a free-text field in the form; for referential integrity consider
     * mapping to a course identifier in the service layer.
     * </p>
     */
	private String courseName;
	
	/**
     * Current status of the enquiry.
     * <p>
     * Example values: "NEW", "ENROLLED", "LOST". Consider validating against
     * known statuses or using a status enum to avoid invalid values.
     * </p>
     */
	private String enquiryStatus;
}