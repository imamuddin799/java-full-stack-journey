package in.ansari;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Servlet initializer to support traditional WAR deployment to a servlet container.
 *
 * <p>When packaging the application as a WAR (instead of a standalone JAR with an embedded container),
 * servlet containers (Tomcat, Jetty, etc.) use this class to bootstrap the Spring application context.
 * Extending SpringBootServletInitializer allows configuring the application builder with the primary
 * Spring Boot application class.
 *
 * Design notes:
 * - Keep this class minimal; heavy startup logic should live in lifecycle beans (CommandLineRunner, ApplicationRunner).
 * - This class is only required for WAR deployments. For executable JARs the main application class is sufficient.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    /**
     * Configure the application when launched by the servlet container.
     *
     * <p>Spring passes a SpringApplicationBuilder which can be customized before the context is created.
     * Here we point it at the primary @SpringBootApplication class to ensure the same configuration is used
     * in both embedded and container deployments.
     *
     * @param application builder provided by the framework
     * @return the configured builder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BlogAppApplication.class);
    }
}
