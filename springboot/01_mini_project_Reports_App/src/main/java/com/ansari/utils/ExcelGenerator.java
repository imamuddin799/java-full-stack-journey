package com.ansari.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.ansari.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

/**
 * The {@code ExcelGenerator} class is responsible for generating Excel reports
 * (.xlsx format) containing details of {@link CitizenPlan} records.
 * <p>
 * This class uses Apache POI’s {@link XSSFWorkbook} implementation to create
 * modern Excel files and dynamically write tabular data. It supports flexible
 * output targets — either writing directly to an HTTP response stream (for file
 * downloads) or saving to a specified file path on the local disk.
 * </p>
 *
 * <h3>Key Features:</h3>
 * <ul>
 *   <li>Generates .xlsx Excel files (Office Open XML format).</li>
 *   <li>Supports both web and file-system export options.</li>
 *   <li>Automatically writes headers and formats data rows.</li>
 *   <li>Handles null or missing data gracefully by inserting blank cells.</li>
 * </ul>
 *
 * <h3>Example Usage (Web Response):</h3>
 * <pre>{@code
 * @Autowired
 * private ExcelGenerator excelGenerator;
 *
 * @GetMapping("/export")
 * public void exportExcel(HttpServletResponse response) throws IOException {
 *     response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
 *     response.setHeader("Content-Disposition", "attachment; filename=plans.xlsx");
 *     excelGenerator.generateExcel(response, citizenPlanList);
 * }
 * }</pre>
 *
 * <h3>Example Usage (File System):</h3>
 * <pre>{@code
 * excelGenerator.generateExcel("D:/reports/plans.xlsx", citizenPlanList);
 * }</pre>
 *
 * @author  Imamuddin
 * @version 1.0
 * @since 2025-11-02
 */

@Component
public class ExcelGenerator {

	/**
     * Generates an Excel (.xlsx) report based on the provided list of {@link CitizenPlan} records.
     * <p>
     * Depending on the type of the {@code response} parameter, the method behaves as follows:
     * <ul>
     *   <li>If {@code response} is an instance of {@link HttpServletResponse}, the Excel
     *       workbook is streamed directly to the browser as a downloadable file.</li>
     *   <li>If {@code response} is a {@link String}, it is treated as a file path and
     *       the Excel workbook is written to disk at that location.</li>
     *   <li>Otherwise, the workbook is discarded and {@code false} is returned.</li>
     * </ul>
     * </p>
     *
     * @param response either a {@link HttpServletResponse} (for web download) or a {@link String} file path (for saving to disk).
     * @param records the list of {@link CitizenPlan} records to be exported. Each record represents one Excel row.
     * @return {@code true} if Excel generation succeeds, {@code false} if the provided response type is unsupported.
     * @throws IOException if an I/O error occurs while writing to a stream or file.
     */
	public boolean generateExcel(Object response, List<CitizenPlan> records) throws IOException {
//		Workbook workbook = new HSSFWorkbook();		// for .xls excel file extension
		
		// Create a new Excel workbook (.xlsx format)
		Workbook xssfWorkbook = new XSSFWorkbook(); // for .xlsx excel file extension
		
        // Create a sheet named "plans-data" to hold report data
		Sheet sheet = xssfWorkbook.createSheet("plans-data");
		
		// --------------------------------------------------------------------
        // STEP 1: Create header row (column titles)
        // --------------------------------------------------------------------
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Gender");
		headerRow.createCell(3).setCellValue("Plan Name");
		headerRow.createCell(4).setCellValue("Plan Status");
		headerRow.createCell(5).setCellValue("Plan Start Date");
		headerRow.createCell(6).setCellValue("Plan End Date");
		headerRow.createCell(7).setCellValue("Plan Termination Date");
		headerRow.createCell(8).setCellValue("Benefit Amt");
		
		// --------------------------------------------------------------------
        // STEP 2: Populate data rows using CitizenPlan records
        // --------------------------------------------------------------------
		int dataRowIndex = 1;
		
		for(CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getGender());
			dataRow.createCell(3).setCellValue(plan.getPlanName());
			dataRow.createCell(4).setCellValue(plan.getPlanStatus());
			
            // Handle date columns safely (avoid null pointer)
			if(null != plan.getPlanStartDate()) {
				dataRow.createCell(5).setCellValue(plan.getPlanStartDate()+"");
			} else {
				dataRow.createCell(5).setCellValue("");	
			}
			if(null != plan.getPlanEndDate()) {
				dataRow.createCell(6).setCellValue(plan.getPlanEndDate()+"");
			} else {
				dataRow.createCell(6).setCellValue("");	
			}
			if(null != plan.getTerminatedDate()) {
				dataRow.createCell(7).setCellValue(plan.getTerminatedDate()+"");
			} else {
				dataRow.createCell(7).setCellValue("");	
			}
			
			// Benefit amount may be numeric or null
			if(null !=  plan.getBenefitAmt()) {
				dataRow.createCell(8).setCellValue(plan.getBenefitAmt());
			} else {
				dataRow.createCell(8).setCellValue("");
			}
			
			dataRowIndex++;
		}
		
		// --------------------------------------------------------------------
        // STEP 3: Output the generated workbook
        // --------------------------------------------------------------------
		if (response instanceof HttpServletResponse) {
			// Write workbook to HTTP response (for browser download)
	        ServletOutputStream os = ((HttpServletResponse) response).getOutputStream();
	        xssfWorkbook.write(os);
	        os.close();
	    } else if (response instanceof String) {
            // Write workbook to file system
	        FileOutputStream fos = new FileOutputStream(new File((String) response));
	        xssfWorkbook.write(fos);
	        fos.close();
	    } else {
            // Unsupported response type
	    	xssfWorkbook.close();
	    	return false;
	    }
		
//		FileOutputStream stream = new FileOutputStream(new File("plans.xls"));
//		workbook.write(stream);
		
//		ServletOutputStream outputStream = response.getOutputStream();
//		xssfWorkbook.write(outputStream);
		
        // Close workbook resource to prevent memory leaks
		xssfWorkbook.close();
		return true;
	}
}