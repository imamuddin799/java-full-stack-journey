package in.ansari.exception; // Package grouping for custom application exceptions related to domain and service operations

/**
 * Exception thrown when a requested resource cannot be found.
 *
 * <p>This is an unchecked runtime exception used across the service and controller
 * layers to signal "not found" conditions (HTTP 404 equivalent in web contexts).
 * Throwing a RuntimeException here simplifies propagation through transactional
 * boundaries without requiring checked-exception boilerplate.
 *
 * Design notes:
 * - Keep this exception lightweight: it carries a human-readable message that
 *   can be rendered to API clients or logged for diagnostics.
 * - Do not include persistence or HTTP-layer specifics in this class; map this
 *   exception to appropriate transport-layer responses in an exception handler
 *   (e.g., @ControllerAdvice in Spring MVC).
 * - Avoid exposing sensitive internal details in the message when throwing this
 *   exception from production code.
 */
public class ResourceNotFoundException extends RuntimeException { // Unchecked exception to represent missing resources in domain/service logic
    public ResourceNotFoundException(String msg) { // Constructor accepting a descriptive message; used when creating the exception instance
        super(msg); // Delegate to RuntimeException to store the message and initialize the exception stack trace
    } // End of constructor
} // End of class ResourceNotFoundException
