package in.ansari.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ansari.binding.DashboardResponse;
import in.ansari.binding.EnquiryForm;
import in.ansari.binding.EnquirySearchCriteria;
import in.ansari.entity.CourseEntity;
import in.ansari.entity.StudentEnquiryEntity;
import in.ansari.entity.UserDetailsEntity;
import in.ansari.repository.CourseRepository;
import in.ansari.repository.EnquiryStatusRepository;
import in.ansari.repository.StudentEnquiryRepository;
import in.ansari.repository.UserDetailsRepository;
import jakarta.servlet.http.HttpSession;

/**
 * Service implementation for managing student enquiries and producing dashboard metrics.
 * <p>
 * Coordinates repository access and session-scoped user context to:
 * - compute dashboard counts for a user
 * - list courses and enquiry statuses
 * - create or update student enquiries
 * - fetch, filter, and retrieve individual enquiries
 * </p>
 * <p>
 * Design notes:
 * - Methods that depend on the current user read the user id from {@link HttpSession}.
 * - Several methods return null when the user is not found; consider returning empty lists
 *   or throwing a domain-specific exception to simplify controller logic.
 * - Filtering and counting are performed in-memory from the user's loaded enquiry list.
 *   For large datasets prefer repository queries to leverage database filtering and aggregation.
 * - The code relies on plain-text status and classMode comparisons; standardize values
 *   (enums or constants) to avoid fragile string comparisons.
 * </p>
 */

@Service
public class EnquiryServiceImplementation implements EnquiryService {
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private EnquiryStatusRepository enquiryStatusRepository;
	
	@Autowired
	private StudentEnquiryRepository studentEnquiryRepository;
	
	@Autowired
	HttpSession session;

	/**
     * Build dashboard metrics (total, enrolled, lost) for the given user id.
     * <p>
     * Loads the user and counts statuses from the user's enquiry collection.
     * Returns an empty {@link DashboardResponse} when the user is not found.
     * </p>
     *
     * @param userId the id of the user
     * @return dashboard metrics with counts set when user exists; otherwise an empty response
     */
	@Override
	public DashboardResponse getDashboardData(Integer userId) {
		DashboardResponse dashboardResponse = new DashboardResponse();
		Optional<UserDetailsEntity> optional = userDetailsRepository.findById(userId);
		if(optional.isPresent()) {
			UserDetailsEntity userDetailsEntity = optional.get();
			List<StudentEnquiryEntity> enquiries = userDetailsEntity.getStudentEnquiryEntities();
			Integer totalEnquiries = enquiries.size();
			Integer enrolledCount = enquiries.stream().filter(enquiry -> enquiry.getEnquiryStatus().equals("ENROLLED")).collect(Collectors.toList()).size();
			Integer lostCount = enquiries.stream().filter(enquiry -> enquiry.getEnquiryStatus().equals("LOST")).collect(Collectors.toList()).size();
			dashboardResponse.setTotalEnquiriesCount(totalEnquiries);
			dashboardResponse.setEnrolledCount(enrolledCount);
			dashboardResponse.setLostCount(lostCount);
		}
		return dashboardResponse;
	}

	/**
     * Return a list of course names.
     * <p>
     * Loads all CourseEntity entries and maps to their names.
     * </p>
     *
     * @return list of course names; empty list if none exist
     */
	@Override
	public List<String> getCourses() {
		List<CourseEntity> courses = courseRepository.findAll();
		List<String> courseNames = new ArrayList<>();
		for(CourseEntity course : courses) {
			courseNames.add(course.getCourseName());
		}
		return courseNames;
	}

	/**
     * Retrieve enquiry status names via the repository projection.
     *
     * @return list of enquiry status names
     */
	@Override
	public List<String> getEnquiryStatuses() {
		return enquiryStatusRepository.getEnquiryStatusList();
	}

	/**
     * Save or update a student enquiry from the provided form.
     * <p>
     * If enquiryId is present the existing entity is loaded; otherwise a new entity is created.
     * The current user (from session) is set as the owner before saving.
     * </p>
     *
     * @param form enquiry form data
     * @return true when save succeeds; false when the current user cannot be resolved
     */
	@Override
	public boolean saveEnquiry(EnquiryForm form) {
		StudentEnquiryEntity studentEnquiryEntity;
		if(null != form.getEnquiryId()) {
			studentEnquiryEntity = studentEnquiryRepository.findById(form.getEnquiryId()).orElse(new StudentEnquiryEntity());
		} else {
			studentEnquiryEntity = new StudentEnquiryEntity();
		}
		BeanUtils.copyProperties(form, studentEnquiryEntity);
		Integer userId = (Integer) session.getAttribute("userId");
		Optional<UserDetailsEntity> optional = userDetailsRepository.findById(userId);
		if(optional.isPresent()) {
			UserDetailsEntity userDetailsEntity = optional.get();
			studentEnquiryEntity.setUserDetailsEntity(userDetailsEntity);
		} else {
			return false;
		}
		studentEnquiryRepository.save(studentEnquiryEntity);
		return true;
	}
	
	/**
     * Return all enquiries for the currently logged-in user.
     *
     * @return list of StudentEnquiryEntity for the session user; null if user not found
     */
	@Override
	public List<StudentEnquiryEntity> getStudentEnquiries() {
		Integer userId = (Integer) session.getAttribute("userId");
		Optional<UserDetailsEntity> findById = userDetailsRepository.findById(userId);
		if(findById.isPresent()) {
			UserDetailsEntity userDetailsEntity = findById.get();
			List<StudentEnquiryEntity> enquiryEntity = userDetailsEntity.getStudentEnquiryEntities();
			return enquiryEntity;
		}
		return null;
	}
	
	/**
     * Filter the current user's enquiries according to provided criteria.
     * <p>
     * All criteria fields are optional; null or empty values are ignored.
     * Filtering is applied in-memory on the user's enquiry collection.
     * </p>
     *
     * @param criteria search criteria
     * @return filtered list of enquiries; null if session user cannot be resolved
     */
	@Override
	public List<StudentEnquiryEntity> getFilteredEnquiries(EnquirySearchCriteria criteria) {
		Integer userId = (Integer) session.getAttribute("userId");
		Optional<UserDetailsEntity> findById = userDetailsRepository.findById(userId);
		if(findById.isPresent()) {
			UserDetailsEntity userDetailsEntity = findById.get();
			List<StudentEnquiryEntity> enquiryEntity = userDetailsEntity.getStudentEnquiryEntities();
			
			if(null != criteria.getCourseName() && !"".equals(criteria.getCourseName())) {
				enquiryEntity = enquiryEntity.stream()
				.filter(entity -> 
					entity.getCourseName()
					.equals(criteria.getCourseName())
				).collect(Collectors.toList());
			}
			
			if(null != criteria.getEnquiryStatus() && !"".equals(criteria.getEnquiryStatus())) {
				enquiryEntity = enquiryEntity.stream()
				.filter(entity -> 
					entity.getEnquiryStatus()
					.equals(criteria.getEnquiryStatus())
				).collect(Collectors.toList());
			}
			
			if(null != criteria.getClassMode() && !"".equals(criteria.getClassMode())) {
				enquiryEntity = enquiryEntity.stream()
				.filter(entity -> 
					entity.getClassMode()
					.equals(criteria.getClassMode())
				).collect(Collectors.toList());
			}
			
			return enquiryEntity;
		}
		return null;
	}
	
	/**
     * Load a single enquiry by its id.
     *
     * @param enquiryId enquiry identifier
     * @return found StudentEnquiryEntity or null when not present
     */
	@Override
	public StudentEnquiryEntity getStudentEnquiryById(Integer enquiryId) {
		Optional<StudentEnquiryEntity> findById = studentEnquiryRepository.findById(enquiryId);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}
}
