package com.ansari.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * Represents a citizen's plan information stored in the database.
 * 
 * <p>This entity maps to the database table that contains details about each citizen’s
 * government or insurance plan, including their personal details and plan metadata.
 * It is used for generating various reports and for performing search operations
 * based on plan name, status, gender, and date ranges.</p>
 * 
 * <p><strong>Example use:</strong></p>
 * <pre>
 * CitizenPlan plan = new CitizenPlan();
 * plan.setCitizenName("Imamuddin Ansari");
 * plan.setPlanName("Health Insurance");
 * plan.setPlanStatus("Approved");
 * plan.setGender("Male");
 * plan.setStartDate(LocalDate.of(2024, 1, 10));
 * plan.setEndDate(LocalDate.of(2025, 1, 10));
 * </pre>
 * 
 * <p>Each record in this entity can be exported to Excel or PDF for reporting.</p>
 */

@Data
@Entity
@Table(name = "CITIZEN_PLANS_INFO")
public class CitizenPlan {
	
	/**
     * Primary key — auto-generated unique identifier for each citizen plan record.
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer citizenId;
	
	/**
     * Name of the citizen enrolled in the plan.
     */
	private String citizenName;
	
	/**
     * Gender of the citizen, used for filtering and reporting.
     */
	private String gender;
	
	/**
     * The type or name of the plan, such as "Health Insurance", "Retirement Plan", etc.
     */
	private String planName;
	
	/**
     * The current status of the plan (e.g., "Approved", "Denied", "Pending").
     */
	private String planStatus;
	
	/**
     * The start date of the citizen's plan.
     */
	private LocalDate planStartDate;
	
	/**
     * The end date of the citizen's plan.
     */
	private LocalDate planEndDate;
	
	/**
     * The amount of benefit sanctioned to the citizen (if applicable).
     */
	private Double benefitAmt;
	
	/**
     * The reason for plan denial (if applicable). May be null if plan is approved.
     */
	private String denialReason;
	private LocalDate terminatedDate;
	private String terminationReason;
}