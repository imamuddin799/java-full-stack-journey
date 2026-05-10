package in.ansari.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ansari.entity.User;

import java.util.Optional;

/**
 * Repository interface for User entities.
 *
 * <p>Extends Spring Data JPA's JpaRepository to inherit a rich set of CRUD
 * and pagination operations for the User entity type. This interface declares
 * additional query methods derived from method names that the Spring Data
 * infrastructure will implement at runtime.
 *
 * Design notes:
 * - Keep repository interfaces focused on persistence concerns; complex queries
 *   or multi-step operations should be placed in dedicated custom repository
 *   implementations or in the service layer.
 * - Method names follow Spring Data's query derivation conventions so no JPQL
 *   or SQL is required here. For advanced queries, consider @Query annotations
 *   or a custom repository.
 *
 * Usage:
 * - Inject this interface into services or controllers (prefer constructor
 *   injection) and call the provided methods to access User data.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    
    // Derived query method that returns an Optional of User by email.
    // Spring Data JPA parses the method name and constructs a query like:
    // SELECT u FROM User u WHERE u.email = ?1
    // Optional is used to explicitly represent possible absence of a matching user.
    Optional<User> findByEmail(String email);

    // Derived query method that checks existence of a user by email.
    // Spring Data generates an efficient SELECT 1 ... WHERE email = ?1 query,
    // allowing the caller to quickly determine uniqueness without fetching the entity.
    boolean existsByEmail(String email);
}
