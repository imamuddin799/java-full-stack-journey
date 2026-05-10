package in.ansari.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.ansari.dto.LoginRequest;
import in.ansari.dto.RegisterRequest;
import in.ansari.entity.User;
import in.ansari.exception.UnauthorizedException;
import in.ansari.service.AuthService;

/**
 * Controller responsible for user authentication flows: registration, login and logout.
 *
 * <p>Responsibilities:
 * - Render registration and login pages.
 * - Accept and validate form submissions for register/login.
 * - Delegate business logic to AuthService.
 * - Manage simple session attributes for authenticated users.
 *
 * Design notes:
 * - Keeps controller methods thin: validation, basic error handling and session management only.
 * - Service layer performs sensitive actions (password hashing, authentication checks).
 * - Uses RedirectAttributes for Post/Redirect/Get flow after successful registration.
 */
@Controller
public class AuthController {

    // Service responsible for registering and authenticating users; injected by constructor
    private final AuthService authService;

    // Constructor injection for easy testing and immutability of the dependency
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    /**
     * Render the registration page.
     *
     * <p>Adds an empty RegisterRequest to the model so the form can bind to it.
     *
     * @param model Spring MVC Model to expose attributes to the view template
     * @return logical view name "register"
     */
    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("register", new RegisterRequest()); // form backing object
        return "register"; // resolves to templates/register.html (or configured view)
    }

    /**
     * Handle registration form submission.
     *
     * <p>Behavior:
     * - Validates the incoming RegisterRequest using @Valid; validation results in BindingResult.
     * - If validation fails, returns to the registration view to display errors.
     * - Delegates creation to AuthService.register and uses RedirectAttributes to show a flash success message.
     * - If the email is already registered, catches IllegalArgumentException and re-renders the form with an error.
     *
     * @param request DTO bound from the form and validated
     * @param result holds validation errors after @Valid processing
     * @param redirectAttributes used to pass flash attributes after a redirect
     * @param model used to repopulate the form on error
     * @return redirect to login on success or the register view on error
     */
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("register") RegisterRequest request, BindingResult result,
            RedirectAttributes redirectAttributes, Model model) {

        // If bean validation failed, re-render the form to show errors
        if (result.hasErrors()) {
            return "register";
        }

        try {
            // Delegate to service layer which enforces uniqueness and persists the user
            authService.register(request);

            // Use Post/Redirect/Get: add a flash attribute and redirect to login to avoid form resubmission
            redirectAttributes.addFlashAttribute("success", "Registration successful. Please log in.");
            return "redirect:/login";
        } catch (IllegalArgumentException ex) {
            // Expected business validation failure (e.g., duplicate email). Re-render form with error message.
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("register", request); // repopulate form fields
            return "register";
        }
    }

    /**
     * Render the login page.
     *
     * <p>Adds an empty LoginRequest to the model so the login form can bind to it.
     *
     * @param model Spring MVC Model to expose attributes to the view template
     * @return logical view name "login"
     */
    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("login", new LoginRequest()); // form backing object for login
        return "login"; // resolves to templates/login.html
    }

    /**
     * Handle login form submission.
     *
     * <p>Behavior:
     * - Validates the LoginRequest with @Valid; on validation failure, re-render login view.
     * - Delegates authentication to AuthService.login which throws UnauthorizedException on failure.
     * - On success, stores minimal user info in the HTTP session and redirects to the home page.
     * - On authentication failure, displays an error on the login page.
     *
     * Security notes:
     * - Password handling and verification occur inside AuthService; controller must not log sensitive data.
     * - Session contains only IDs and non-sensitive display values; do not store password or secrets here.
     *
     * @param request validated login DTO
     * @param result holds validation errors after @Valid processing
     * @param session HTTP session used to store authenticated user context
     * @param model used to return error messages to the view on failure
     * @return redirect to home on success or the login view on error
     */
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("login") LoginRequest request, BindingResult result, HttpSession session,
            Model model) {

        // If validation fails, show the login page again with validation errors
        if (result.hasErrors()) {
            return "login";
        }

        try {
            // Delegate authentication; service throws UnauthorizedException if credentials are invalid
            User user = authService.login(request);

            // Store minimal user context in session for downstream controllers and templates
            session.setAttribute("USER_ID", user.getId());
            session.setAttribute("USER_NAME", user.getName());
            session.setAttribute("USER_EMAIL", user.getEmail());

            // Redirect to home after successful login
            return "redirect:/";
        } catch (UnauthorizedException ex) {
            // Authentication failed — show error message without revealing specifics
            model.addAttribute("error", ex.getMessage());
            return "login";
        }
    }

    /**
     * Logout the current user by invalidating the HTTP session.
     *
     * <p>After invalidation, redirect to the public home page.
     *
     * @param session HTTP session to invalidate
     * @return redirect to home page
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate(); // remove all session attributes and mark session invalid
        return "redirect:/"; // send the user back to the public index
    }
}
