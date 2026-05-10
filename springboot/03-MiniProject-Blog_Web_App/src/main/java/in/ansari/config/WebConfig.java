package in.ansari.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Web MVC configuration for the application.
 *
 * <p>Provides small framework-level customizations:
 * - Optional view controller registrations (simple URL -> view mappings).
 * - Application-wide CORS configuration used by browser-based clients.
 *
 * Design notes:
 * - Keep WebMvcConfigurer implementations focused and minimal to avoid hiding framework defaults.
 * - For fine-grained CORS rules prefer controller-level @CrossOrigin annotations or fine-grained registry rules.
 * - When allowCredentials(true) is used, avoid allowedOrigins("*") — use allowedOriginPatterns or explicit hosts.
 */
@Configuration // Marks this as a configuration class discovered by component scanning
public class WebConfig implements WebMvcConfigurer {

    /**
     * Register simple view controllers.
     *
     * <p>This method is intentionally left available for lightweight mappings where
     * no controller logic is required (for example, mapping "/" directly to a template).
     * Keeping mappings here avoids creating trivial controller classes.
     *
     * If you prefer explicit controllers (more flexible for model population and security),
     * leave this no-op and handle the mapping in a Controller class instead.
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // Optional: map "/" to index controller explicitly or via controller
        // Example alternative (uncomment if desired):
        // registry.addViewController("/").setViewName("index");
    }

    /**
     * Configure global CORS settings for the application.
     *
     * <p>Current configuration:
     * - Applies to all paths ("/**").
     * - Allows any origin pattern via allowedOriginPatterns("*") which is safer when allowCredentials(true) is used.
     * - Allows common HTTP methods used by the app: GET, POST, PUT, DELETE.
     * - Allows credentials (cookies, HTTP authentication) to be sent cross-origin.
     *
     * Security notes:
     * - When allowCredentials(true) is enabled, avoid allowedOrigins("*") because browsers will reject the response.
     *   allowedOriginPatterns("*") is used here as a compatibility measure while still permitting credentialed requests.
     * - Prefer restricting allowedOriginPatterns to a known list of trusted host patterns in production.
     * - Consider also restricting allowedHeaders and exposing specific headers with exposedHeaders(...) as needed.
     *
     * @param registry CorsRegistry provided by Spring to register mappings
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // Use allowedOriginPatterns to support credentialed requests while permitting flexible patterns.
                .allowedOriginPatterns("*")
                // Limit allowed HTTP methods to those the application expects.
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                // Allow cookies and other credentials to be sent in CORS requests.
                .allowCredentials(true);
    }
}
