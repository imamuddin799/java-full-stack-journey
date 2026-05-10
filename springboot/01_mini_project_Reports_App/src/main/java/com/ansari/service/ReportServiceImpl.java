package com.ansari.service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.openpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.ansari.controller.ReportController;
import com.ansari.entity.CitizenPlan;
import com.ansari.repo.CitizenPlanRepository;
import com.ansari.request.SearchRequest;
import com.ansari.utils.EmailUtils;
import com.ansari.utils.ExcelGenerator;
import com.ansari.utils.PdfGenerator;

import jakarta.servlet.http.HttpServletResponse;

/**
 * Implementation class for {@link ReportService}.
 * <p>
 * The {@code ReportServiceImpl} acts as the business layer in the application,
 * bridging between the controller layer ({@code ReportController}) and data layer
 * ({@code CitizenPlanRepository}). It handles:
 * <ul>
 *   <li>Search filtering of citizen plan records</li>
 *   <li>Exporting reports into Excel and PDF formats</li>
 *   <li>Sending the generated reports to users via email</li>
 * </ul>
 *
 * <p>All utility dependencies such as {@link ExcelGenerator}, {@link PdfGenerator}, and
 * {@link EmailUtils} are injected using Spring’s {@code @Autowired} mechanism.</p>
 *
 * <p><b>Responsibility:</b> Generate, format, and deliver citizen plan reports.</p>
 *
 * @author
 *     Imamuddin
 * @since
 *     2025
 */
@Service
public class ReportServiceImpl implements ReportService {
	
	 /** Repository interface for accessing citizen plan data. */
	@Autowired
	private CitizenPlanRepository repository;
	
    /** Utility class responsible for generating Excel reports. */
	@Autowired
	private ExcelGenerator excelGenerator;
	
    /** Utility class responsible for generating PDF reports. */
	@Autowired
	private PdfGenerator pdfGenerator;
	
    /** Utility class for sending emails with attachments. */
	@Autowired
	private EmailUtils emailUtils;

	
	
	/**
     * Retrieves all distinct plan names from the database.
     *
     * @return a list of unique plan names available in {@code CitizenPlan} table.
     */
	@Override
	public List<String> getPlanNames() {
		return repository.getPlanNames();
	}

	/**
     * Retrieves all distinct plan statuses from the database.
     *
     * @return a list of unique plan statuses (e.g., Approved, Denied, Pending).
     */
	@Override
	public List<String> getPlanStatuses() {
		return repository.getPlanStatus();
	}

	/**
     * Filters and retrieves {@link CitizenPlan} records based on the
     * non-null and non-empty values from the given {@link SearchRequest}.
     * <p>
     * The filtering is achieved using Spring Data JPA’s {@link Example}
     * query mechanism, which dynamically builds SQL based on non-null fields.
     *
     * @param request an object containing user-defined search criteria such as
     *                plan name, status, gender, and date range.
     * @return a list of matching {@link CitizenPlan} entities.
     */
	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan plan = new CitizenPlan();
		
        // Apply filters only when user provided values
		if(null != request.getPlanName() && !"".equals(request.getPlanName())) {
			plan.setPlanName(request.getPlanName());
		}
		if(null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			plan.setPlanStatus(request.getPlanStatus());
		}
		if(null != request.getGender() && !"".equals(request.getGender())) {
			plan.setGender(request.getGender());
		}
		if(null != request.getStartDate() && !"".equals(request.getStartDate().toString())) {
			plan.setPlanStartDate(request.getStartDate());
		}
		if(null != request.getEndDate() && !"".equals(request.getEndDate()+"")) {
			plan.setPlanEndDate(request.getEndDate());
		}
		
        // Use Example API to create a dynamic query
		return repository.findAll(Example.of(plan));
	}

	/**
     * Exports all citizen plan data into an Excel file and sends it directly
     * as a downloadable response to the client’s browser.
     *
     * @param response {@link HttpServletResponse} used to write the Excel file stream.
     * @throws IOException if an error occurs while writing to the response.
     */
	@Override
	public void exportExcel(HttpServletResponse response) throws IOException {
		List<CitizenPlan> list = repository.findAll();
		excelGenerator.generateExcel(response, list);
	}

	/**
     * Exports all citizen plan data into a PDF file and sends it directly
     * as a downloadable response to the client’s browser.
     *
     * @param response {@link HttpServletResponse} used to write the PDF file stream.
     * @throws IOException if an error occurs while writing to the response.
     */
	@Override
	public void exportPdf(HttpServletResponse response) throws IOException {
		List<CitizenPlan> list = repository.findAll();
		pdfGenerator.generatePdf(response, list);
	}
	
	/**
     * Generates an Excel report file, sends it as an email attachment,
     * and deletes the file after successful transmission.
     * <p>
     * The process flow:
     * <ol>
     *   <li>Generate Excel report using {@link ExcelGenerator}</li>
     *   <li>Attach and send it using {@link EmailUtils}</li>
     *   <li>Delete the temporary file from the server</li>
     * </ol>
     *
     * @return {@code true} if email sent successfully; {@code false} otherwise.
     * @throws IOException if file generation or attachment fails.
     */
	@Override
	public boolean sendExcelToEmail() throws IOException {
		
		String filename = "plans.xlsx";
		
		File file = new File(filename);
		
		// Generate Excel file with all plans
		List<CitizenPlan> list = repository.findAll();
		excelGenerator.generateExcel(filename, list);
		
        // Prepare email details
		String subject = "Test mail subject";
		String body = "<h1>Test mail body</h1>";
		String to = "<email.to.whom.you.want.to.send@gmail.com>";
		
        // Send email with attachment
		boolean email = emailUtils.sendEmail(subject, body, to, filename, file);
		
        // Delete file post transmission
		if (file.delete()) {
            System.out.println("Temporary Excel file deleted successfully.");
        } else {
            System.out.println("Excel file not found or deletion failed.");
        }
		
		return email;
		
//		Path path = Paths.get("plans.xlsx");
//		try {
//			boolean deleted = Files.deleteIfExists(path);
//			if(deleted) {
//				System.out.println("File deleted successfully.");
//			} else {
//				System.out.println("File does not exists.");
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	}
	
	/**
     * Generates a PDF report file, sends it as an email attachment,
     * and deletes the file after sending.
     * <p>
     * The process flow:
     * <ol>
     *   <li>Generate PDF report using {@link PdfGenerator}</li>
     *   <li>Send as an email using {@link EmailUtils}</li>
     *   <li>Delete the temporary PDF after sending</li>
     * </ol>
     *
     * @return {@code true} if the PDF report email is sent successfully; {@code false} otherwise.
     * @throws IOException if the PDF file could not be generated or deleted.
     */
	@Override
	public boolean sendPdfToEmail() throws DocumentException, IOException {
		String filename = "Plans-Info.pdf";
		File file = new File(filename);
		
        // Generate PDF file
		List<CitizenPlan> list = repository.findAll();
		pdfGenerator.generatePdf(filename, list);
		
        // Prepare email content
		String subject = "Test mail subject for pdf";
		String body = "<h1>This Email is generated by Imamuddin's Report Application so please do not reply</h1>";
		String to = "<email.to.whom.you.want.to.send@gmail.com>";
		
        // Send email with PDF attachment
		boolean sendEmail = emailUtils.sendEmail(subject, body, to, filename, file);
		
		// Delete file after sending
        if (file.delete()) {
            System.out.println("Temporary PDF file deleted successfully.");
        } else {
            System.out.println("PDF file not found or deletion failed.");
        }
		
		return sendEmail;
	}
}