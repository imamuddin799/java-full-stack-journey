package in.ansari;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Blog application.
 *
 * <p>This class boots the Spring application context and starts the embedded servlet
 * container (if configured). Keep this class minimal — application configuration,
 * beans, and component scanning are handled via annotations and configuration classes.
 *
 * Design notes:
 * - Annotated with @SpringBootApplication which is a convenience meta-annotation that
 *   combines @Configuration, @EnableAutoConfiguration and @ComponentScan.
 * - Avoid placing heavy logic, blocking calls, or long-running tasks in the main method.
 *   Use CommandLineRunner or dedicated lifecycle beans for startup tasks.
 * - For tests, prefer using SpringBootTest with a different test configuration rather than
 *   invoking this main method directly.
 */
@SpringBootApplication // Enables auto-configuration and component scanning for the application package
public class BlogAppApplication {

    /**
     * Application main method.
     *
     * <p>Delegates to SpringApplication.run which bootstraps the Spring context and starts
     * the application. The args array is forwarded so command-line properties can override
     * configuration (e.g., --server.port, --spring.profiles.active).
     *
     * @param args command-line arguments forwarded to SpringApplication
     */
    public static void main(String[] args) {
        SpringApplication.run(BlogAppApplication.class, args); // Boot the Spring Boot application
    }
}
