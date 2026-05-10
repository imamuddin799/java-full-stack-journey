package com.ansari.service;

import java.io.IOException;
import java.util.List;

import com.ansari.entity.CitizenPlan;
import com.ansari.request.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

/**
 * The {@code ReportService} interface defines a contract for generating, exporting,
 * and sending reports related to {@link CitizenPlan} data.
 * <p>
 * Implementations of this interface are responsible for handling:
 * <ul>
 *   <li>Dynamic search functionality based on user input filters</li>
 *   <li>Exporting report data to Excel and PDF formats</li>
 *   <li>Sending generated reports to users via email</li>
 * </ul>
 *
 * <p>Typical usage flow:</p>
 * <pre>
 *  ┌──────────────────────────┐
 *  │  ReportController calls  │
 *  │   ↓                      │
 *  │  ReportService methods   │
 *  │   ↓                      │
 *  │  Repository + Utilities  │
 *  │  (ExcelUtils, PdfUtils)  │
 *  └──────────────────────────┘
 * </pre>
 *
 * This interface is implemented by {@code ReportServiceImpl}.
 *
 * @author
 *     Imamuddin
 * @since
 *     2025
 */
public interface ReportService {

	/**
     * Retrieves all distinct plan names available in the database.
     *
     * @return a list of plan names as {@link String}, sorted as per database order.
     */
	public List<String> getPlanNames();
	
	/**
     * Retrieves all distinct plan statuses available in the database.
     *
     * @return a list of plan statuses as {@link String}, e.g., "Approved", "Denied", "Pending".
     */
	public List<String> getPlanStatuses();
	
	/**
     * Performs a dynamic search of citizen plans based on provided filter criteria.
     * <p>
     * The filtering can include attributes such as plan name, plan status, gender,
     * and a date range for the plan's start and end dates.
     *
     * @param request an instance of {@link SearchRequest} containing user-selected
     *                filter values; fields that are {@code null} or empty are ignored.
     * @return a list of {@link CitizenPlan} records that match the search filters.
     */
	public List<CitizenPlan> search(SearchRequest request);
	
	/**
     * Generates an Excel file containing report data and writes it directly
     * to the provided HTTP response stream for client download.
     *
     * @param response the {@link HttpServletResponse} object used to write
     *                 the generated Excel file to the browser.
     * @throws IOException if there is an error writing the Excel file.
     */
	public void exportExcel(HttpServletResponse response) throws IOException;
	
	/**
     * Generates a PDF file containing report data and writes it directly
     * to the provided HTTP response stream for client download.
     *
     * @param response the {@link HttpServletResponse} object used to write
     *                 the generated PDF file to the browser.
     * @throws IOException if there is an error writing the PDF file.
     */
	public void exportPdf(HttpServletResponse response) throws IOException;
	
	/**
     * Generates the latest report in Excel format and sends it as an email attachment
     * to a predefined recipient (typically the administrator or user).
     *
     * @return {@code true} if the email was sent successfully; {@code false} otherwise.
     * @throws IOException if the Excel file cannot be generated or attached.
     */
	public boolean sendExcelToEmail() throws IOException;
	
	/**
     * Generates the latest report in PDF format and sends it as an email attachment
     * to a predefined recipient (typically the administrator or user).
     *
     * @return {@code true} if the email was sent successfully; {@code false} otherwise.
     * @throws IOException if the PDF file cannot be generated or attached.
     */
	public boolean sendPdfToEmail() throws IOException;
}
