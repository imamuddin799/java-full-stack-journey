package in.ansari.controller;

import org.springframework.http.ResponseEntity; // For building HTTP responses with status and body
import org.springframework.stereotype.Controller; // Marks this class as a Spring MVC controller for view rendering
import org.springframework.ui.Model; // Model used to pass attributes to a server-side view (Thymeleaf, JSP, etc.)
import org.springframework.web.bind.annotation.GetMapping; // Shortcut for @RequestMapping(method = RequestMethod.GET)
import org.springframework.web.bind.annotation.RequestParam; // Binds HTTP request parameters to method arguments
import org.springframework.web.bind.annotation.ResponseBody; // Indicates the return value should be used as the response body

import in.ansari.dto.BlogResponse; // DTO returned to clients representing blog data for presentation
import in.ansari.service.BlogService; // Service boundary for blog-related operations

import java.util.List; // Collection type for ordered lists

/**
 * Controller responsible for public search and home page endpoints.
 *
 * <p>Responsibilities:
 * - Render the home/index page with a list of active blogs (server-side view).
 * - Provide a lightweight JSON search endpoint used by client-side code or API consumers.
 *
 * Design notes:
 * - Keep controller methods thin: delegate business logic to BlogService and focus on
 *   transport/presentation concerns (mapping results to the model or HTTP responses).
 * - Index endpoint returns a view name which the view resolver will resolve to a template.
 * - Search endpoint returns JSON directly and is annotated with @ResponseBody to bypass view resolution.
 * - For consistency and separation of concerns, consider exposing a dedicated REST controller
 *   (annotated with @RestController) for richer API surface in the future.
 */
@Controller // Spring stereotype indicating this class handles web requests and may return views
public class SearchController {

    // Service used to load and search blog posts; injected via constructor
    private final BlogService blogService;

    // Constructor injection makes the dependency explicit and supports easier testing
    public SearchController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * Render the public index (home) page.
     *
     * <p>This endpoint fetches active blogs via the BlogService and adds them to the Model
     * so the view template can render the list. It returns the logical view name "index";
     * the configured view resolver (e.g., Thymeleaf) will resolve it to an actual template.
     *
     * @param model Spring MVC Model used to expose attributes to the view template
     * @return logical view name for the home/index page
     */
    @GetMapping("/") // Handle GET requests to the application root
    public String index(Model model) {
        // Retrieve all non-deleted blogs ordered by creation date (service handles mapping to DTO)
        List<BlogResponse> blogs = blogService.listActive();

        // Add the blogs list to the model under the attribute name "blogs" for template rendering
        model.addAttribute("blogs", blogs);

        // Return the view name; view resolver will locate and render the template (e.g., templates/index.html)
        return "index";
    }

    /**
     * Search active blogs using a textual query and return JSON results.
     *
     * <p>The endpoint is intentionally simple and returns a ResponseEntity containing
     * a list of BlogResponse DTOs. Marked with @ResponseBody to indicate the return value
     * should be serialized directly to the HTTP response body (JSON).
     *
     * Security and validation notes:
     * - Method currently trusts the 'q' parameter; consider validating or restricting length
     *   to prevent excessive database load or injection attempts.
     * - For public-facing APIs, apply rate limiting, input sanitization, and caching as needed.
     *
     * @param q search query text submitted as a required request parameter
     * @return HTTP 200 response containing a list of matching BlogResponse DTOs
     */
    @GetMapping("/search") // Handle GET requests for search operations
    @ResponseBody // Serialize the return value directly to the HTTP response body (JSON)
    public ResponseEntity<List<BlogResponse>> search(@RequestParam String q) {
        // Delegate search to the service layer which returns ordered DTOs based on relevance
        List<BlogResponse> results = blogService.search(q);

        // Return OK (200) with the search results in the response body
        return ResponseEntity.ok(results);
    }
}
