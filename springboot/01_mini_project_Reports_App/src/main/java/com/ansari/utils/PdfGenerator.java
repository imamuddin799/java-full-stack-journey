package com.ansari.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import org.openpdf.text.Document;
import org.openpdf.text.DocumentException;
import org.openpdf.text.Element;
import org.openpdf.text.PageSize;
import org.openpdf.text.Paragraph;
import org.openpdf.text.Phrase;
import org.openpdf.text.pdf.PdfPCell;
import org.openpdf.text.pdf.PdfPTable;
import org.openpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import com.ansari.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

/**
 * The {@code PdfGenerator} class is a utility component responsible for generating
 * PDF reports containing details of {@link CitizenPlan} records using the OpenPDF library.
 * <p>
 * It supports both web-based export (writing directly to {@link HttpServletResponse})
 * and file-based export (writing to a file path). The PDF document includes a table layout
 * with citizen plan details and metadata for better readability.
 * </p>
 *
 * <h3>Features:</h3>
 * <ul>
 *   <li>Generates portrait-oriented A4-sized PDFs for better table visibility.</li>
 *   <li>Writes data dynamically using {@link PdfPTable} for proper alignment and structure.</li>
 *   <li>Supports dynamic output destinations: HTTP response or file system.</li>
 *   <li>Centers date columns and automatically skips null or empty fields.</li>
 * </ul>
 *
 * <h3>Example Usage (Web Response):</h3>
 * <pre>{@code
 * @Autowired
 * private PdfGenerator pdfGenerator;
 *
 * @GetMapping("/export-pdf")
 * public void exportPdf(HttpServletResponse response) throws DocumentException, IOException {
 *     response.setContentType("application/pdf");
 *     response.setHeader("Content-Disposition", "attachment; filename=plans.pdf");
 *     pdfGenerator.generatePdf(response, citizenPlanList);
 * }
 * }</pre>
 *
 * <h3>Example Usage (File System):</h3>
 * <pre>{@code
 * pdfGenerator.generatePdf("D:/reports/plans.pdf", citizenPlanList);
 * }</pre>
 *
 * @author  Imamuddin
 * @version 1.0
 * @since 2025-11-02
 */

@Component
public class PdfGenerator {

	/**
     * Generates a formatted PDF document containing a table of {@link CitizenPlan} data.
     * <p>
     * The method automatically detects the output destination based on the {@code object} parameter:
     * <ul>
     *   <li>If {@code object} is an instance of {@link HttpServletResponse}, the generated PDF
     *       is streamed directly to the browser for download.</li>
     *   <li>If {@code object} is a {@link String}, it is interpreted as a file path and the
     *       PDF is saved to that location.</li>
     * </ul>
     * </p>
     *
     * <p>The document includes:
     * <ul>
     *   <li>A report title ("Citizen Plans Info")</li>
     *   <li>A data table with headers and aligned columns</li>
     *   <li>A footer remark acknowledging the report source</li>
     * </ul>
     * </p>
     *
     * @param object an {@link HttpServletResponse} (for web export) or a {@link String} file path (for file save)
     * @param records a list of {@link CitizenPlan} entities to be displayed in the PDF
     * @throws DocumentException if a PDF document error occurs during writing
     * @throws IOException if an I/O error occurs during file or stream operations
     */
	public void generatePdf(Object object, List<CitizenPlan> records) throws DocumentException, IOException {
		
		// --------------------------------------------------------------------
        // STEP 1: Initialize the PDF Document
        // --------------------------------------------------------------------
		Document document = new Document(PageSize.A4);	// Standard A4 portrait layout
		
        // Determine output destination (HTTP or file)
		if(object instanceof HttpServletResponse) {
			PdfWriter.getInstance(document, ((HttpServletResponse) object).getOutputStream());
		} else if (object instanceof String) {
			OutputStream outputStream = new FileOutputStream(new File((String) object));
			PdfWriter.getInstance(document, outputStream);
		}
		
        // Open the document for writing
		document.open();
		
		// --------------------------------------------------------------------
        // STEP 2: Add Title / Header Section
        // --------------------------------------------------------------------
		Paragraph p = new Paragraph("Citizen Plans Info \n\n");
		document.add(p);
		
		// --------------------------------------------------------------------
        // STEP 3: Create and Configure Table
        // --------------------------------------------------------------------
		PdfPTable table = new PdfPTable(6);	// 6 columns for relevant data fields
		
		table.setWidthPercentage(100);	// Table width covers full page width
        
		// Define column widths for uniform alignment
		float[] columnWidths = {4f, 13f, 12f, 12f, 10f, 10f};
		table.setWidths(columnWidths);
		
		// Add table headers
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		// --------------------------------------------------------------------
        // STEP 4: Populate Table Rows with Data
        // --------------------------------------------------------------------
		for(CitizenPlan plan : records) {
			table.addCell(plan.getCitizenId()+"");
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			
            // Add Start Date (center aligned)
			if(null != plan.getPlanStartDate()) {
				PdfPCell cell = new PdfPCell(new Phrase(plan.getPlanStartDate()+""));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			} else {
				table.addCell("");
			}
			
            // Add End Date (center aligned)
			if(null != plan.getPlanEndDate()) {
				PdfPCell cell = new PdfPCell(new Phrase(plan.getPlanEndDate()+""));
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			} else {
				table.addCell("");
			}
		}
		
		// --------------------------------------------------------------------
        // STEP 5: Add Table and Footer to Document
        // --------------------------------------------------------------------
		// Footer paragraph (source note)
		Paragraph paragraph = new Paragraph("This report is generated by Imamuddin's Report Application");
		document.add(table);
		document.add(paragraph);
		
		// --------------------------------------------------------------------
        // STEP 6: Close Document
        // --------------------------------------------------------------------
		document.close();
	}
}