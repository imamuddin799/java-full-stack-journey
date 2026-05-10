package com.ansari.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ansari.entity.CitizenPlan;
/**
 * Repository interface for performing CRUD operations and custom queries
 * on {@link CitizenPlan} entities.
 *
 * <p>This interface extends {@link JpaRepository} which provides standard
 * data access methods such as save(), findAll(), findById(), deleteById(), etc.</p>
 *
 * <p>Additional custom queries are defined using the @Query annotation.</p>
 *
 * @author Imamuddin
 * @since 2025
 */
public interface CitizenPlanRepository extends JpaRepository<CitizenPlan, Integer> {
	/**
     * Fetches a distinct list of all available plan names.
     *
     * @return list of unique plan names present in the database
     */
	@Query("select distinct(planName) from CitizenPlan")
	public List<String> getPlanNames();
	
	/**
     * Fetches a distinct list of all available plan statuses.
     *
     * @return list of unique plan statuses present in the database
     */
	@Query("select distinct(planStatus) from CitizenPlan")
	public List<String> getPlanStatus();
}