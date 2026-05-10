package in.ansari.binding;

import lombok.Data;

/**
 * Data Transfer Object used to encapsulate search criteria for filtering student enquiries.
 * <p>
 * Instances of this class are typically provided by controllers or service layers to
 * perform filtered queries against enquiry data stores. Each field is optional and
 * represents a filter that can be applied; null or empty values indicate that the
 * corresponding filter should be ignored.
 * </p>
 */
@Data
public class EnquirySearchCriteria {

	/**
     * Course name to filter enquiries by.
     * <p>
     * When set, only enquiries matching this course name should be returned.
     * Matching semantics (exact, case-insensitive, partial) are determined by the
     * repository or service layer that consumes this DTO.
     * </p>
     */
	private String courseName;
	
	/**
     * Enquiry status to filter by.
     * <p>
     * Typical values include "NEW", "ENROLLED", "LOST" or other domain-specific
     * statuses. Consumers should validate this value against allowed statuses or
     * map it to the corresponding status entity/enum before querying.
     * </p>
     */
	private String enquiryStatus;
	
	/**
     * Class mode to filter enquiries by.
     * <p>
     * Example values: "Online", "Classroom". Use this field to narrow
     * results to enquiries requesting a specific delivery mode.
     * </p>
     */
	private String classMode;
}