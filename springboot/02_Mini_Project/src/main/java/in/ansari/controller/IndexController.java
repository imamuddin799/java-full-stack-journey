package in.ansari.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller that handles the application's root URL.
 * <p>
 * Maps GET requests for "/" to the index view. Intended as the landing page
 * entry point for the web application. Keep this controller lightweight and
 * delegate complex routing or model preparation to dedicated controllers/services.
 * </p>
 */
@Controller
public class IndexController {

	/**
     * Serve the index view for the application's root path.
     * <p>
     * Returns the logical view name "index" which should resolve to a template
     * (for example Thymeleaf, JSP, or other view technology) configured in the
     * application's view resolver.
     * </p>
     *
     * @return the view name "index"
     */
	@GetMapping("/")
	public String indexPage() {
		return "index";
	}
}