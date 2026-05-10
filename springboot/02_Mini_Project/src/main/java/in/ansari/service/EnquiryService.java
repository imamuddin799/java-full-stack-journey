package in.ansari.service;

import java.util.List;

import in.ansari.binding.DashboardResponse;
import in.ansari.binding.EnquiryForm;
import in.ansari.binding.EnquirySearchCriteria;
import in.ansari.entity.StudentEnquiryEntity;

/**
 * Service contract for managing student enquiries and producing dashboard metrics.
 * <p>
 * Implementations coordinate between controllers, repositories, and utility components
 * to perform business operations such as creating and retrieving enquiries, filtering
 * results, and aggregating counts for dashboards.
 * </p>
 */
public interface EnquiryService {

	/**
     * Build dashboard metrics for a given user.
     * <p>
     * Typical responsibilities:
     * - compute total enquiries visible to the user
     * - compute how many enquiries are enrolled and how many are lost
     * - return the results packaged in a {@link DashboardResponse}.
     * </p>
     *
     * @param userId the id of the user for whom to compute dashboard data; may be {@code null}
     *               if metrics are global depending on implementation
     * @return a {@link DashboardResponse} containing aggregated counts; fields may be {@code null}
     *         if no data exists
     */
	public DashboardResponse getDashboardData(Integer userId);
	
	/**
     * Retrieve the list of available course names.
     * <p>
     * This method typically delegates to a course repository or cache and returns
     * a list of course names used for populating UI dropdowns or filters.
     * </p>
     *
     * @return a list of course names; an empty list if none are available
     */
	public List<String> getCourses();
	
	/**
     * Retrieve the list of enquiry status names.
     * <p>
     * Returns values such as "NEW", "ENROLLED", "LOST" which are used by the UI
     * and filtering logic. The list should be stable and suitable for binding to form controls.
     * </p>
     *
     * @return a list of enquiry status names; an empty list if none exist
     */
	public List<String> getEnquiryStatuses();
	
	/**
     * Persist a new student enquiry or update an existing one from form data.
     * <p>
     * Responsibilities:
     * - validate and map {@link EnquiryForm} to {@link StudentEnquiryEntity}
     * - set audit fields or ownership if needed (for example from the current user)
     * - save the entity and return operation status
     * </p>
     *
     * @param enquiryForm the form containing enquiry data; must not be {@code null}
     * @return {@code true} if the enquiry was successfully saved or updated; {@code false} otherwise
     */
	public boolean saveEnquiry(EnquiryForm enquiryForm);
	
	/**
     * Retrieve all student enquiries visible to the caller.
     * <p>
     * The visibility (all users or a specific user) is determined by the implementation.
     * </p>
     *
     * @return a list of {@link StudentEnquiryEntity}; empty list when no enquiries exist
     */
	public List<StudentEnquiryEntity> getStudentEnquiries();
	
	/**
     * Retrieve enquiries filtered by the given search criteria.
     * <p>
     * Criteria fields are optional and implementations should ignore null or empty values.
     * Matching semantics (exact or partial, case sensitivity) should be documented by the
     * implementation and consistent with the UI behavior.
     * </p>
     *
     * @param criteria the {@link EnquirySearchCriteria} containing optional filters; must not be {@code null}
     * @return a list of enquiries that match the criteria; empty list if none match
     */
	public List<StudentEnquiryEntity> getFilteredEnquiries(EnquirySearchCriteria criteria);
	
	/**
     * Load a single student enquiry by its identifier.
     * <p>
     * Used to populate edit or detail views. Implementations may return {@code null}
     * if the enquiry is not found or throw a specific exception depending on design.
     * </p>
     *
     * @param enquiryId the id of the enquiry to retrieve; must not be {@code null}
     * @return the matching {@link StudentEnquiryEntity} or {@code null} if not found
     */
	public StudentEnquiryEntity getStudentEnquiryById(Integer enquiryId);
}