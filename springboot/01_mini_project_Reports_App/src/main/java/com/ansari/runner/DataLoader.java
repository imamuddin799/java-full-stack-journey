package com.ansari.runner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.ansari.entity.CitizenPlan;
import com.ansari.repo.CitizenPlanRepository;

/**
 * ============================================================
 *  CLASS NAME: DataLoader
 * ============================================================
 *  DESCRIPTION:
 *  The {@code DataLoader} class is a Spring Boot startup component that
 *  automatically runs when the application is launched. It implements
 *  {@link ApplicationRunner}, enabling it to execute data initialization logic
 *  once the Spring context has fully loaded.
 *
 *  This class is primarily responsible for:
 *  <ul>
 *      <li>Preloading sample data into the database for testing or demonstration purposes.</li>
 *      <li>Creating multiple {@link CitizenPlan} objects with different plan names,
 *          statuses, genders, and date ranges.</li>
 *      <li>Ensuring that new users have immediate data to view and filter on the
 *          Citizen Plans Report page.</li>
 *  </ul>
 *
 *  It helps developers and testers quickly verify report generation,
 *  searching, and export functionalities without manually adding records.
 *
 *  AUTHOR: Imamuddin Ansari  
 *  VERSION: 1.0  
 *  SINCE: 2025-11-02
 */

@Component
public class DataLoader implements ApplicationRunner {

    /** Repository dependency for performing CRUD operations on {@link CitizenPlan} entities. */
    @Autowired
    private CitizenPlanRepository citizenPlanRepo;

    /**
     * Executes automatically after the Spring Application Context is fully initialized.
     * <p>
     * This method seeds the database with a predefined list of {@link CitizenPlan}
     * objects. Each record is designed to represent different plan categories,
     * approval statuses, genders, and timelines to simulate realistic data.
     * </p>
     *
     * @param args ApplicationArguments arguments passed to the application (not used here).
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        citizenPlanRepo.deleteAll(); // Clear existing data to avoid duplication.

        Random random = new Random();

        List<String> names = Arrays.asList("Imran", "Kavita", "Ramesh", "Anita", "Vikram", "Sara", "John", "Sana", "Raj", "Meena");
        List<String> genders = Arrays.asList("Male", "Female");
        List<String> planNames = Arrays.asList("Cash", "Food", "Medical", "Employment");
        List<String> planStatuses = Arrays.asList("Approved", "Denied", "Terminated");
        
        List<CitizenPlan> dataToInsert = new ArrayList<>();

        for (String planName : planNames) {
            for (String status : planStatuses) {

                // Create 3 dummy records for each combination
                for (int i = 1; i <= 3; i++) {
                    CitizenPlan plan = new CitizenPlan();

                    // Basic info
                    plan.setCitizenName(names.get(random.nextInt(names.size())) + " " + i);
                    plan.setGender(genders.get(random.nextInt(genders.size())));
                    plan.setPlanName(planName);
                    plan.setPlanStatus(status);

                    if (status.equals("Approved")) {
                        // Generate start and end date
                        LocalDate startDate = LocalDate.now().minusMonths(random.nextInt(12));
                        LocalDate endDate = startDate.plusMonths(6);

                        plan.setPlanStartDate(startDate);
                        plan.setPlanEndDate(endDate);
                        plan.setBenefitAmt(4000.0 + random.nextInt(6000));

                    } else if (status.equals("Denied")) {
                        // Denied → no dates
                        plan.setDenialReason("Documents not verified");

                    } else if (status.equals("Terminated")) {
                        // Generate start and end date
                        LocalDate startDate = LocalDate.now().minusMonths(random.nextInt(12));
                        LocalDate endDate = startDate.plusMonths(6);
                        plan.setPlanStartDate(startDate);
                        plan.setPlanEndDate(endDate);
                        plan.setBenefitAmt(4000.0 + random.nextInt(6000));
                        plan.setTerminationReason("Policy Violation");

                        // Termination date between start and end date
                        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
                        long randomOffset = 1 + random.nextInt((int) daysBetween - 1);
                        plan.setTerminatedDate(startDate.plusDays(randomOffset));
                    }
                    dataToInsert.add(plan);
                }
            }
        }

        // ================================================================
        // Save all sample data in one batch to improve performance
        // ================================================================
        citizenPlanRepo.saveAll(dataToInsert);
        
        // Log a message to confirm successful data loading
        System.out.println("✅ Data inserted successfully: " + dataToInsert.size() + " records created!");
    }
}
