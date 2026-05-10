package com.ansari.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.ansari.entity.CitizenPlan;
import com.ansari.request.SearchRequest;
import com.ansari.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

/**
 * ============================================================
 *  CLASS NAME: ReportController
 * ============================================================
 *  DESCRIPTION:
 *  This controller class acts as the central entry point for handling
 *  all HTTP requests related to Citizen Plan Reports. It manages:
 *  <ul>
 *      <li>Loading the main index page with search filters and plan data.</li>
 *      <li>Processing user search requests.</li>
 *      <li>Exporting reports in Excel and PDF formats.</li>
 *      <li>Sending generated reports as email attachments.</li>
 *  </ul>
 *
 *  It follows the MVC architecture — where this controller serves as
 *  the **C (Controller)** that connects the **View (index.jsp)** and
 *  the **Model (Service + Entity + Repository)**.
 *
 *  DEPENDENCIES:
 *  <ul>
 *      <li>{@link ReportService} - Handles business logic and data retrieval.</li>
 *      <li>{@link EmailUtils} - Handles email sending functionality.</li>
 *  </ul>
 *
 *  AUTHOR: Imamuddin Ansari
 *  VERSION: 1.0
 *  SINCE: 2025-11-02
 */

@Controller
@SessionAttributes("search")
public class ReportController {

	@Autowired
	private ReportService service;
	
	/**
     * Displays the main report page (index.jsp) with initialized dropdown values.
     * <p>
     * This method is mapped to the root URL ("/") and initializes all
     * required model attributes such as plan names, plan statuses, and
     * an empty {@link SearchRequest} object.
     * </p>
     *
     * @param model The {@link Model} object used to send data to the JSP view.
     * @return The name of the view to be rendered ("index").
     */
	@GetMapping("/")
	public String indexPage(Model model) {
		SearchRequest searchObj = new SearchRequest();
//		searchObj.setStartDate(LocalDate.now());
		model.addAttribute("search", searchObj);
		init(model);
		return "index";
	}

	/**
     * Handles user-submitted search requests and displays the filtered plans.
     * <p>
     * This method processes POST requests made to "/search" and retrieves
     * all matching {@link CitizenPlan} records based on the user's input
     * criteria (plan name, status, gender, start date, end date).
     * </p>
     *
     * @param request The {@link SearchRequest} object containing filter criteria.
     * @param model   The {@link Model} used to pass data back to the view.
     * @return The same "index" view but with filtered search results displayed.
     */
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest request, Model model) {
		System.out.println(request);
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}
	
	/**
     * Generates and downloads the report in Excel format.
     * <p>
     * The Excel file is dynamically created and streamed as a response
     * when the user clicks the "Export Excel" link.
     * </p>
     *
     * @return A {@code void} response, as the file is directly written to the output stream.
     */
	@GetMapping("/excel")
	public void excelExport(HttpServletResponse response) throws IOException {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=plans.xlsx");
		service.exportExcel(response);
	}
	
	/**
     * Generates and downloads the report in PDF format.
     * <p>
     * The PDF file is dynamically created and streamed as a response
     * when the user clicks the "Export PDF" link.
     * </p>
     *
     * @return A {@code void} response, as the file is directly written to the output stream.
     */
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=plans.pdf");
		service.exportPdf(response);
	}
	
	/**
     * Generates an Excel report and sends it to a predefined email address.
     * <p>
     * The file is temporarily saved on disk, attached to an email, and
     * then deleted after successful transmission.
     * </p>
     *
     * @param model Used to display a success or failure message in the view.
     * @return Redirects to the "index" page after email operation completion.
     */
	@GetMapping("/email-excel")
	public String sendExcelToEmail(@ModelAttribute("search") SearchRequest request, Model model) throws IOException {
		boolean emailSent = service.sendExcelToEmail();
		if (emailSent) {
			model.addAttribute("excelToEmailMsg", "Excel has been send to your email");
		} else {
			model.addAttribute("excelToEmailMsg", "Excel could not be sent to your email");
		}
		init(model);
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		return "index";
	}
	
	/**
     * Generates a PDF report and sends it to a predefined email address.
     * <p>
     * The file is temporarily saved on disk, attached to an email, and
     * then deleted after successful transmission.
     * </p>
     *
     * @param model Used to display a success or failure message in the view.
     * @return Redirects to the "index" page after email operation completion.
     */
	@GetMapping("/email-pdf")
	public String sendPdfToEmail(@ModelAttribute("search") SearchRequest request, Model model) throws IOException {
		boolean toEmail = service.sendPdfToEmail();
		if (toEmail) {
			model.addAttribute("pdfToEmailMsg", "PDF has been send to your email");
		} else {
			model.addAttribute("pdfToEmailMsg", "PDF could not be sent to your email");
		}
		init(model);
		List<CitizenPlan> plans = service.search(request);
		model.addAttribute("plans", plans);
		return "index";
	}
	
	/**
     * Initializes model attributes required by the JSP view.
     * <p>
     * Populates dropdown lists for plan names and statuses, and ensures
     * a fresh {@link SearchRequest} object is available for data binding.
     * </p>
     *
     * @param model The {@link Model} object used to pass data to the view.
     */
	private void init(Model model) {
		model.addAttribute("names", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatuses());
	}
}