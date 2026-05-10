package in.ansari.binding;

import lombok.Data;

/**
 * DTO used to convey dashboard metrics related to student enquiries.
 * <p>
 * Carries aggregated counts such as total enquiries, how many resulted in
 * enrollment, and how many were lost. Intended for use by controller layers
 * or service responses that populate dashboard views or API endpoints.
 * </p>
 */
@Data
public class DashboardResponse {

	/**
     * Total number of enquiries recorded.
     * <p>
     * This is an aggregated count of all enquiry records considered in the
     * dashboard context (for example within a date range, for a user, or for all users).
     * </p>
     */
	private Integer totalEnquiriesCount;
	
	/**
     * Number of enquiries that resulted in enrollment.
     * <p>
     * Represents the subset of enquiries whose outcome is considered successful
     * (for example status equals "ENROLLED"). Value may be {@code null} if not set.
     * </p>
     */
	private Integer enrolledCount;
	
	/**
     * Number of enquiries that were lost.
     * <p>
     * Represents enquiries that did not convert (for example status equals "LOST").
     * Value may be {@code null} if not set.
     * </p>
     */
	private Integer lostCount;
}