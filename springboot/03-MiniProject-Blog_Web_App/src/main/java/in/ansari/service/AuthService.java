package in.ansari.service; // Package grouping for service layer interfaces that define business operations

import in.ansari.dto.LoginRequest; // DTO representing authentication credentials submitted by clients
import in.ansari.dto.RegisterRequest; // DTO representing data required to register a new user
import in.ansari.entity.User; // Domain entity representing persisted user accounts

/**
 * Service contract for authentication-related operations.
 *
 * <p>This interface defines the core authentication and user lifecycle use-cases
 * exposed by the application service layer: registering new users, authenticating
 * existing users, and retrieving user details by id. Implementations should
 * encapsulate security-sensitive logic such as password hashing, token/session
 * creation, credential verification, validation, and mapping between DTOs and
 * entities.
 *
 * Design and responsibility notes:
 * - Keep business rules (password strength, uniqueness checks, verification email
 *   sending) inside the implementation rather than in controllers or repositories.
 * - Implementations should avoid returning sensitive fields (e.g., raw password)
 *   or should map entities to safe response types when exposing data to API layers.
 * - Methods return the User entity for convenience; if UI/clients must not see
 *   entity internals, map to DTOs in the service or controller layer.
 */
public interface AuthService { // Service interface defining authentication-related operations
    
    /**
     * Register a new user account using data from the RegisterRequest.
     *
     * <p>Expected responsibilities of the implementation:
     * - Validate input data and enforce uniqueness constraints (email).
     * - Hash and salt the provided password before persistence.
     * - Persist a new User entity via a repository within a transactional boundary.
     * - Optionally trigger post-registration flows (verification email, welcome events).
     *
     * @param request DTO containing registration details (name, email, password)
     * @return the persisted User entity representing the newly created account
     */
    User register(RegisterRequest request); // Registers a new user and returns the persisted User entity

    /**
     * Authenticate a user with credentials provided in LoginRequest.
     *
     * <p>Expected responsibilities of the implementation:
     * - Validate credentials against stored password hash using a secure algorithm.
     * - Enforce account state checks (locked, disabled, verified) as required.
     * - Optionally issue authentication tokens or populate session state (but token issuance
     *   may also live in a dedicated token service).
     *
     * @param request DTO containing email and plaintext password supplied by the client
     * @return the authenticated User entity when credentials are valid
     */
    User login(LoginRequest request); // Authenticates a user and returns the corresponding User entity on success

    /**
     * Retrieve a User entity by its identifier.
     *
     * <p>Implementations should consider whether to return the raw entity or map to a safer
     * projection for external consumption. This method is typically used by other services
     * to load user data for authorization or auditing purposes.
     *
     * @param id primary key of the user to retrieve
     * @return the User entity with the given id, or null/throw if not found depending on implementation conventions
     */
    User getById(Long id); // Fetch a User by primary key; behavior for not-found should be defined by the implementation
}
