package com.ansari.request;

import java.time.LocalDate;

import lombok.Data;

/**
 * Encapsulates the user’s search input for generating citizen plan reports.
 * 
 * <p>This class is used as a Data Transfer Object (DTO) to carry the filtering
 * parameters entered by the user from the UI layer (typically via a JSP form)
 * to the backend service layer. It allows users to filter results based on
 * plan name, status, gender, and a date range.</p>
 * 
 * <p><strong>Use case:</strong> When a user submits the report search form on
 * the web page, Spring MVC automatically binds the form inputs to an instance
 * of this class using {@code @ModelAttribute("searchRequest")}. The populated
 * object is then passed to the controller and service layers for processing.</p>
 * 
 * <p><strong>Example usage:</strong></p>
 * <pre>
 * SearchRequest request = new SearchRequest();
 * request.setPlanName("Health Insurance");
 * request.setPlanStatus("Approved");
 * request.setGender("Female");
 * request.setStartDate(LocalDate.of(2024, 1, 1));
 * request.setEndDate(LocalDate.of(2024, 12, 31));
 * </pre>
 * 
 * <p>This example represents a user searching for all approved female citizens
 * under the "Health Insurance" plan within the year 2024.</p>
 */
@Data
public class SearchRequest {
	
	/**
     * The name of the plan being searched for (e.g., "Health Insurance").
     * 
     * <p>Used to filter records by the specific plan name.</p>
     */
	private String planName;
	
	/**
     * The current status of the plan to filter by (e.g., "Approved", "Denied", "Pending").
     * 
     * <p>Allows users to generate reports based on plan status categories.</p>
     */
	private String planStatus;
	
	/**
     * The gender of citizens to include in the search (e.g., "Male", "Female").
     * 
     * <p>This helps in demographic-based filtering for reports.</p>
     */
	private String gender;
	
	/**
     * The start date from which plan records should be included.
     * 
     * <p>Used as the lower bound of the date range filter. Typically corresponds to plan start date.</p>
     */
	private LocalDate startDate;
	
	/**
     * The end date until which plan records should be included.
     * 
     * <p>Used as the upper bound of the date range filter. Typically corresponds to plan end date.</p>
     */
	private LocalDate endDate;

}