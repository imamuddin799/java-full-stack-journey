package in.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ansari.entity.UserDetailsEntity;

/**
 * Repository interface for performing CRUD and query operations on UserDetailsEntity.
 * <p>
 * Extends Spring Data JPA's {@link JpaRepository} to inherit common persistence
 * methods such as save, findById, findAll, delete, and support for pagination and sorting.
 * The concrete implementation is provided at runtime by Spring Data JPA.
 * </p>
 * <p>
 * Type parameters:
 * <ul>
 *   <li>UserDetailsEntity — the entity type managed by this repository</li>
 *   <li>Integer — the type of the entity primary key</li>
 * </ul>
 * </p>
 * <p>
 * Typical usage: inject this interface into service or controller classes to perform
 * database operations related to user details and to execute custom finder methods
 * declared below.
 * </p>
 */
public interface UserDetailsRepository extends JpaRepository<UserDetailsEntity, Integer> {

	/**
     * Find a user by their email address.
     * <p>
     * Spring Data interprets the method name and generates a query to locate a
     * {@link UserDetailsEntity} whose {@code userEmail} field matches the provided email.
     * </p>
     *
     * @param email the email address to search for; must not be {@code null}
     * @return the matching {@link UserDetailsEntity} if present; otherwise {@code null}
     * @throws org.springframework.dao.DataAccessException if a data access error occurs
     */
	public UserDetailsEntity findByUserEmail(String email);
	
	/**
     * Find a user by email and password.
     * <p>
     * Spring Data will derive a query that matches both {@code userEmail} and {@code password}
     * fields. This method is typically used for simple authentication flows; ensure that
     * {@code password} is a hashed value and not plain text when calling this method.
     * Prefer delegating authentication to a dedicated security component (for example Spring Security)
     * rather than relying on direct repository lookups for production systems.
     * </p>
     *
     * @param email the email address to search for; must not be {@code null}
     * @param password the password hash to match; must not be {@code null}
     * @return the matching {@link UserDetailsEntity} if credentials match; otherwise {@code null}
     * @throws org.springframework.dao.DataAccessException if a data access error occurs
     */
	public UserDetailsEntity findByUserEmailAndPassword(String email, String password);
}