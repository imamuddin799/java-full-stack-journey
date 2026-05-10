package in.ansari.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ansari.binding.LoginForm;
import in.ansari.binding.SignUpForm;
import in.ansari.binding.UnlockForm;
import in.ansari.service.UserService;

/**
 * MVC controller that handles user registration, unlocking, authentication and password recovery flows.
 * <p>
 * This controller is view-oriented: it binds form objects, invokes {@link UserService} for business logic,
 * and adds success/error attributes to the model for rendering the appropriate views.
 * It returns logical view names (or redirects) which should be resolved by the configured view technology.
 * </p>
 *
 * Routes:
 * - GET  /signup       -> show registration page
 * - POST /signup       -> process registration and send unlock email
 * - GET  /unlock       -> show unlock form prefilled with email
 * - POST /unlock       -> verify temporary password and set new password
 * - GET  /login        -> show login page
 * - POST /login        -> authenticate and redirect to dashboard on success
 * - GET  /forgot       -> show forgot-password page
 * - POST /forgot       -> initiate forgot-password flow
 */

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	/**
     * Handle sign-up form submission.
     * <p>
     * Delegates creation to {@link UserService#signup(SignUpForm)}. On success sets
     * a "successMessage" in the model; on failure sets an "errorMessage".
     * Returns the signup view so the page can display feedback.
     * </p>
     */
	@PostMapping("/signup")
	public String handleSignUp(@ModelAttribute("user") SignUpForm form, Model model) {
		boolean status = userService.signup(form);
		
		if(status) {
			model.addAttribute("successMessage", "Account Created, Check Your Email");
		} else {
			model.addAttribute("errorMessage", "Choose Unique Email");
		}
		return "signup";
	}

	/**
     * Serve the sign-up page with an empty SignUpForm for binding.
     */
	@GetMapping("/signup")
	public String signUpPage(Model model) {
		model.addAttribute("user", new SignUpForm());
		return "signup";
	}
	
	/**
     * Serve the unlock page prefilled with the email query parameter.
     */
	@GetMapping("/unlock")
	public String unlockPage(@RequestParam String email, Model model) {
		UnlockForm unlockForm = new UnlockForm();
		unlockForm.setEmail(email);
		model.addAttribute("unlock", unlockForm);
		return "unlock";
	}
	
	/**
     * Handle unlock form submission.
     * <p>
     * Verifies newPassword and confirmPassword match, then delegates unlocking to
     * {@link UserService#unlockAccount(UnlockForm)}. Adds appropriate success or error
     * messages to the model and returns the unlock view for user feedback.
     * </p>
     */
	@PostMapping("/unlock")
	public String handleUnlock(@ModelAttribute("unlock") UnlockForm unlockForm, Model model) {
		if(unlockForm.getNewPassword().equals(unlockForm.getConfirmPassword())) {
			boolean status = userService.unlockAccount(unlockForm);
			if(status) {
				model.addAttribute("successMessage", "Your Account Unlocked Successfully");
			} else {
				model.addAttribute("errorMessage", "Given Temporary Password is Incorrect, Check Your Email");
			}
		} else {
			model.addAttribute("errorMessage", "New Password and Confirm Password should be same");
		}
		return "unlock";
	}
	
	/**
     * Serve the login page with an empty LoginForm for binding.
     */
	@GetMapping("/login")
	public String loginPage(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "login";
	}
	
	/**
     * Handle login submission.
     * <p>
     * Calls {@link UserService#login(LoginForm)} and, on "success", redirects to /dashboard.
     * Otherwise adds an "errorMessage" populated with the service response and returns the login view.
     * </p>
     */
	@PostMapping("/login")
	public String handleLogin(@ModelAttribute("loginForm") LoginForm loginForm, Model model) {
		String login = userService.login(loginForm);
		if(login.contains("success")) {
			return "redirect:/dashboard";
		}
		model.addAttribute("errorMessage", login);
		return "login";
	}
	
	/**
     * Serve the forgot-password page.
     */
	@GetMapping("/forgot")
	public String forgotPasswordPage() {
		return "forgot-password";
	}
	
	/**
     * Handle forgot-password submission.
     * <p>
     * Delegates to {@link UserService#forgotPassword(String)} and sets a success or error
     * message on the model based on the boolean result. Returns the forgot-password view.
     * </p>
     */
	@PostMapping("/forgot")
	public String forgotPassword(@RequestParam("email") String email, Model model) {
		boolean status = userService.forgotPassword(email);
		if(status) {
			model.addAttribute("successMessage", "Password sent to your email");
		} else {
			model.addAttribute("errorMessage", "Invalid Email");
		}
		return "forgot-password";
	}
}