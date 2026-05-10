package in.ansari.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ansari.entity.EnquiryStatusEntity;

/**
 * Repository interface for EnquiryStatusEntity persistence operations.
 * <p>
 * Extends Spring Data JPA's {@link JpaRepository} to provide standard CRUD,
 * pagination, and sorting operations for {@link EnquiryStatusEntity} instances.
 * Spring Data will provide the implementation at runtime.
 * </p>
 * <p>
 * Type parameters:
 * <ul>
 *   <li>EnquiryStatusEntity — the entity this repository manages</li>
 *   <li>Integer — the type of the entity primary key</li>
 * </ul>
 * </p>
 * <p>
 * Typical usage: inject this repository into service classes to load, create,
 * update, or delete enquiry status records and to run custom queries that
 * return status-related projections.
 * </p>
 */
public interface EnquiryStatusRepository extends JpaRepository<EnquiryStatusEntity, Integer> {

	/**
     * Retrieve the list of enquiry status names.
     * <p>
     * Executes a JPQL query that selects only the {@code statusName} property from
     * all {@link EnquiryStatusEntity} rows. This returns a list of plain strings
     * suitable for populating UI dropdowns or validating status values.
     * </p>
     *
     * @return a {@link List} of {@link String} containing each enquiry status name;
     *         the list will be empty if no statuses exist in the database.
     * @implNote The query uses JPQL projection to return only the {@code statusName}
     *           column which reduces payload compared to fetching full entities.
     *           If ordering or filtering is required, extend the JPQL accordingly.
     * @throws org.springframework.dao.DataAccessException on data access errors
     *         thrown by the Spring Data infrastructure during query execution.
     */
	@Query("Select statusName from EnquiryStatusEntity")
	public List<String> getEnquiryStatusList();
}