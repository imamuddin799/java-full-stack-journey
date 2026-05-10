package in.ansari.service.impl;

import in.ansari.dto.LoginRequest;
import in.ansari.dto.RegisterRequest;
import in.ansari.entity.User;
import in.ansari.exception.UnauthorizedException;
import in.ansari.repository.UserRepository;
import in.ansari.service.AuthService;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service implementation for authentication-related operations.
 *
 * <p>Responsibilities:
 * - Register new users (validate uniqueness, hash passwords).
 * - Authenticate users by verifying credentials.
 * - Provide simple user lookup by id.
 *
 * Design notes:
 * - Methods are transactional to ensure consistent persistence behavior.
 * - Password hashing uses BCrypt with a work factor of 12 for reasonable security vs performance.
 * - This class returns User entities directly; map to DTOs at controller/response boundaries if you
 *   need to avoid leaking sensitive fields (e.g., passwordHash).
 */
@Service // Marks this class as a Spring service component
@Transactional // Ensures methods execute inside a transactional boundary by default
public class AuthServiceImpl implements AuthService {

    // Repository used to persist and lookup users
    private final UserRepository userRepository;

    // Constructor injection for testability and immutability of the dependency
    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Register a new user account.
     *
     * <p>Steps performed:
     * 1. Check for existing account with the same email and reject if present.
     * 2. Generate a BCrypt salt and hash the provided plaintext password.
     * 3. Build a User entity with normalized name and email, storing the password hash.
     * 4. Persist and return the saved User.
     *
     * Security notes:
     * - Email is normalized to lowercase and trimmed to reduce duplicates caused by casing/whitespace.
     * - Name is trimmed to avoid accidental leading/trailing whitespace.
     * - Plaintext passwords must never be logged; callers should treat RegisterRequest as sensitive.
     *
     * @param request registration payload containing name, email and plaintext password
     * @return persisted User entity representing the newly created account
     * @throws IllegalArgumentException when the email is already registered
     */
    @Override
    public User register(RegisterRequest request) {
        // Ensure email uniqueness before creating a new account
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already registered");
        }

        // Generate salt and hash password using BCrypt. Work factor 12 is chosen as a balance.
        String salt = BCrypt.gensalt(12);
        String hash = BCrypt.hashpw(request.getPassword(), salt);

        // Map request to entity with basic normalization
        User user = User.builder()
                .name(request.getName().trim())
                .email(request.getEmail().toLowerCase().trim())
                .passwordHash(hash)
                .build();

        // Persist the new user and return the managed entity
        return userRepository.save(user);
    }

    /**
     * Authenticate a user using email and password.
     *
     * <p>Steps performed:
     * 1. Normalize email and attempt to load the user by email.
     * 2. If user is not found or password check fails, throw UnauthorizedException.
     * 3. Return the User entity on successful authentication.
     *
     * Security notes:
     * - The password check uses BCrypt.checkpw which safely verifies the password against the stored hash.
     * - Returns the User entity; avoid exposing passwordHash outside trusted layers.
     *
     * @param request login payload containing email and plaintext password
     * @return authenticated User entity
     * @throws UnauthorizedException when credentials are invalid
     */
    @Override
    public User login(LoginRequest request) {
        // Load user by normalized email, throw if not found to avoid revealing which part failed
        User user = userRepository.findByEmail(request.getEmail().toLowerCase().trim())
                .orElseThrow(() -> new UnauthorizedException("Invalid credentials"));

        // Verify the provided password against stored BCrypt hash
        if (!BCrypt.checkpw(request.getPassword(), user.getPasswordHash())) {
            throw new UnauthorizedException("Invalid credentials");
        }

        // Successful authentication — return user for downstream processing (token creation, session, etc.)
        return user;
    }

    /**
     * Retrieve a user by id.
     *
     * <p>Implementation returns null when the user is not found. Callers may prefer
     * to throw a ResourceNotFoundException instead depending on semantics; adjust
     * here or at the service boundary as needed.
     *
     * @param id primary key of the user
     * @return User entity if found, otherwise null
     */
    @Override
    public User getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
