package in.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ansari.entity.StudentEnquiryEntity;

/**
 * Repository interface for StudentEnquiryEntity persistence operations.
 * <p>
 * Extends Spring Data JPA's {@link JpaRepository} to provide standard CRUD,
 * pagination, and sorting operations for {@link StudentEnquiryEntity} instances.
 * Spring Data supplies the runtime implementation based on this interface.
 * </p>
 * <p>
 * Type parameters:
 * <ul>
 *   <li>StudentEnquiryEntity — the entity this repository manages</li>
 *   <li>Integer — the type of the entity primary key</li>
 * </ul>
 * </p>
 * <p>
 * Typical usage: inject this repository into a service or controller to create,
 * read, update, and delete student enquiry records and to leverage built-in
 * query derivation, pagination, and sorting features provided by Spring Data JPA.
 * </p>
 */
public interface StudentEnquiryRepository extends JpaRepository<StudentEnquiryEntity, Integer> {

}