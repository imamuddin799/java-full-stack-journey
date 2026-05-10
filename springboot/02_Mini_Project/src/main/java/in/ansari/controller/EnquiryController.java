package in.ansari.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ansari.binding.DashboardResponse;
import in.ansari.binding.EnquiryForm;
import in.ansari.binding.EnquirySearchCriteria;
import in.ansari.entity.StudentEnquiryEntity;
import in.ansari.service.EnquiryService;
import jakarta.servlet.http.HttpSession;

/**
 * MVC controller that manages student enquiry workflows and dashboard views.
 * <p>
 * Responsibilities:
 * - Session management (logout)
 * - Dashboard metrics retrieval for the logged-in user
 * - Serve add/edit enquiry pages and process form submissions
 * - Provide lists required to initialize enquiry forms (courses, statuses)
 * - List all enquiries and return filtered enquiry views
 * </p>
 * <p>
 * Notes and recommendations:
 * - The controller depends on a session attribute "userId" set after authentication.
 *   Ensure controllers that set this attribute always do so on successful login.
 * - Many methods return view names and populate the model for server-side rendering.
 * - Consider standardizing null/empty handling: current code may return null lists if the
 *   service cannot resolve the session user. Prefer returning empty lists to simplify views.
 * - For mutating endpoints (POST), consider Post/Redirect/Get to avoid duplicate form submissions.
 * - Paging and database-side filtering are recommended when user enquiry lists grow large.
 * </p>
 */

@Controller
public class EnquiryController {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private EnquiryService enquiryService;
	
	/**
     * Invalidate the current HTTP session and return the index view.
     *
     * @return logical view name "index"
     */
	@GetMapping("/logout")
	public String logout() {
		session.invalidate();
		return "index";
	}

	/**
     * Show dashboard page populated with aggregated counts for the logged-in user.
     *
     * @param model model to which dashboardData is added
     * @return logical view name "dashboard"
     */
	@GetMapping("/dashboard")
	public String dashboardPage(Model model) {
		Integer userId = (Integer) session.getAttribute("userId");
		DashboardResponse dashboardData = enquiryService.getDashboardData(userId);
		model.addAttribute("dashboardData", dashboardData);
		return "dashboard";
	}
	
	/**
     * Prepare and serve the add-enquiry page with an empty EnquiryForm and
     * lookup lists (courses, statuses) required by the form.
     *
     * @param model model to which form and lookup data are added
     * @return logical view name "add-enquiry"
     */
	@GetMapping("/enquiry")
	public String addEnquiryPage(Model model) {
		EnquiryForm enquiryForm = new EnquiryForm();
		model.addAttribute("enquiryForm", enquiryForm);
		addEnquiryInitForm(model);
		return "add-enquiry";
	}

	/**
     * Helper to populate model with course and status lists for enquiry forms.
     *
     * @param model model to enrich
     */
	private void addEnquiryInitForm(Model model) {
		List<String> courses = enquiryService.getCourses();
		List<String> enquiryStatuses = enquiryService.getEnquiryStatuses();
		model.addAttribute("courseNames", courses);
		model.addAttribute("enquiryStatusNames", enquiryStatuses);
	}
	
	/**
     * Serve the enquiry update page pre-populated with the existing enquiry values.
     *
     * @param enquiryId id of the enquiry to edit
     * @param model model to which the populated form is added
     * @return logical view name "add-enquiry"
     */
	@GetMapping("/update")
	public String updateEnquiryPage(@RequestParam Integer enquiryId, Model model) {
		StudentEnquiryEntity studentEnquiry = enquiryService.getStudentEnquiryById(enquiryId);
		EnquiryForm enquiryForm = new EnquiryForm();
		BeanUtils.copyProperties(studentEnquiry, enquiryForm);
		enquiryForm.setEnquiryId(enquiryId);
		model.addAttribute("enquiryForm", enquiryForm);
		addEnquiryInitForm(model);
		return "add-enquiry";
	}
	
	/**
     * Handle add or update enquiry form submission.
     * <p>
     * Delegates persistence to {@link EnquiryService#saveEnquiry(EnquiryForm)} and
     * adds success/error messages to the model for the returned view.
     * Consider using Post/Redirect/Get to avoid duplicate submissions after refresh.
     * </p>
     *
     * @param enquiryForm bound form data
     * @param model model to which feedback messages and lookup lists are added
     * @return logical view name "add-enquiry"
     */
	@PostMapping("enquiry")
	public String handleAddEnquiry(@ModelAttribute("enquiryForm") EnquiryForm enquiryForm, Model model) {
		boolean status = enquiryService.saveEnquiry(enquiryForm);
		if(status) {
			if(null != enquiryForm.getEnquiryId()) {
				model.addAttribute("successMessage", "Enquiry Updated");
			} else {
				model.addAttribute("successMessage", "Enquiry Added");
			}
		} else {
			model.addAttribute("errorMessage", "Problem Occured");
		}
		addEnquiryInitForm(model);
		return "add-enquiry";
	}
	
	/**
     * Show the view that lists all enquiries for the logged-in user.
     *
     * @param model model to which the enquiries list is added
     * @return logical view name "view-enquiries"
     */
	@GetMapping("/enquiries")
	public String viewEnquiriesPage(Model model) {
		initForm(model);
		List<StudentEnquiryEntity> enquiries = enquiryService.getStudentEnquiries();
		model.addAttribute("enquiries", enquiries);
		return "view-enquiries";
	}
	
	/**
     * Return a view containing enquiries filtered by course, status and mode.
     * <p>
     * The request parameters are collected into an {@link EnquirySearchCriteria}
     * and passed to the service for filtering.
     * </p>
     *
     * @param course selected course filter
     * @param status selected enquiry status filter
     * @param mode selected class mode filter
     * @param model model to which the filtered list is added
     * @return logical view name "filtered-enquiries-page"
     */
	@GetMapping("/filtered-enquiries")
	public String getFilteredEnquiries(
			@RequestParam String course,
			@RequestParam String status,
			@RequestParam String mode,
			Model model) {
		
		EnquirySearchCriteria searchCriteria = new EnquirySearchCriteria();
		searchCriteria.setClassMode(mode);
		searchCriteria.setCourseName(course);
		searchCriteria.setEnquiryStatus(status);
		
		List<StudentEnquiryEntity> filteredEnquiries = enquiryService.getFilteredEnquiries(searchCriteria);
		model.addAttribute("enquiries", filteredEnquiries);
		
		return "filtered-enquiries-page";
	}
	
	/**
     * Initialize the model with course/status lists and an empty form object used by enquiry listing pages.
     *
     * @param model model to enrich
     */
	private void initForm(Model model) {
		List<String> courses = enquiryService.getCourses();
		List<String> enquiryStatuses = enquiryService.getEnquiryStatuses();
		EnquiryForm enquiryForm = new EnquiryForm();
		
		model.addAttribute("courseNames", courses);
		model.addAttribute("statusNames", enquiryStatuses);
		model.addAttribute("formObject",enquiryForm);
	}
}