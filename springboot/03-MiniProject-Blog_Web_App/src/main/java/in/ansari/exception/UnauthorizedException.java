package in.ansari.exception; // Package for custom exceptions representing application-specific error conditions and intent

/**
 * Thrown to indicate that an authenticated principal attempted an action
 * for which they are not authorized.
 *
 * <p>This is an unchecked runtime exception that service and controller
 * layers can throw when authorization checks fail (HTTP 401/403 semantics).
 * Using a dedicated exception type makes it straightforward to map this
 * condition to a specific HTTP response (for example, via a @ControllerAdvice
 * handler) and to differentiate authorization failures from other errors.
 *
 * Design and usage notes:
 * - This class intentionally extends RuntimeException to avoid checked-exception
 *   propagation across layered boundaries; authorization failures are often
 *   exceptional control-flow events that should be handled centrally.
 * - Do not embed sensitive details (such as access control lists or internal
 *   user identifiers) in the exception message in production environments.
 * - Prefer throwing more specific exception types when you need distinct
 *   handling (e.g., InsufficientScopeException, AccountLockedException).
 */
public class UnauthorizedException extends RuntimeException { // Domain-specific unchecked exception used to indicate authorization failures
    /**
     * Constructs a new UnauthorizedException with the specified detail message.
     *
     * <p>The message should be a concise, non-sensitive description suitable
     * for logging and for use by exception handlers that convert exceptions
     * into user-facing API error payloads.
     *
     * @param msg human-readable detail message describing the authorization failure
     */
    public UnauthorizedException(String msg) { // Single-argument constructor accepting a descriptive message
        super(msg); // Delegate to RuntimeException to store the message and capture the stack trace
    } // End of constructor
} // End of class UnauthorizedException
