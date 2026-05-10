package in.ansari.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import in.ansari.dto.BlogRequest;
import in.ansari.dto.BlogResponse;
import in.ansari.entity.Blog;
import in.ansari.entity.User;
import in.ansari.exception.UnauthorizedException;
import in.ansari.service.AuthService;
import in.ansari.service.BlogService;

/**
 * Controller that handles blog-related web pages and lightweight JSON endpoints.
 *
 * <p>This MVC controller mixes server-side view rendering (Thymeleaf/JSP) and a small
 * REST-like endpoint for AJAX validation. It delegates business rules to BlogService
 * and uses AuthService for session-driven authentication lookups.
 *
 * Design notes:
 * - Keep controllers thin: validation, session checks, short-lived mapping and delegation only.
 * - Authorization is enforced via requireLogin and service-layer owner checks where applicable.
 * - Returned view names correspond to templates resolved by the view resolver (e.g., templates/*.html).
 */
@Controller
@RequestMapping("/blogs")
public class BlogController {

    // Service handling blog business operations (creation, update, deletion, search, paging)
    private final BlogService blogService;

    // Service to resolve authenticated user info from simple session-based storage
    private final AuthService authService;

    // Constructor injection for testability and explicit dependencies
    public BlogController(BlogService blogService, AuthService authService) {
        this.blogService = blogService;
        this.authService = authService;
    }

    /**
     * Helper that enforces a logged-in user by checking the HTTP session.
     *
     * <p>Throws UnauthorizedException when no user id is present. Returns the full
     * User entity retrieved from AuthService which callers can use for ownership checks.
     *
     * @param session current HTTP session
     * @return User entity of the logged-in user
     * @throws UnauthorizedException when the session does not contain a user id
     */
    private User requireLogin(HttpSession session) {
        Long uid = (Long) session.getAttribute("USER_ID");
        if (uid == null)
            throw new UnauthorizedException("Please login to continue");
        return authService.getById(uid);
    }

    /**
     * Render the "add blog" page.
     *
     * <p>If the user is not logged in, redirect to the login page. Otherwise add
     * a fresh BlogRequest backing object for form binding and return the view name.
     *
     * @param model Spring MVC model for view attributes
     * @param session HTTP session used to check login state
     * @return view name or redirect to login
     */
    @GetMapping("/add")
    public String addBlogPage(Model model, HttpSession session) {
        // Quick session check to avoid showing create form to anonymous users
        if (session.getAttribute("USER_ID") == null) {
            return "redirect:/login";
        }
        model.addAttribute("blog", new BlogRequest()); // form backing object
        return "add-blog";
    }

    /**
     * Handle "add blog" form submission.
     *
     * <p>Performs bean validation; on success, ensures the caller is authenticated,
     * delegates creation to the service, and redirects to the created blog's view.
     * On error, re-renders the form with error messages.
     *
     * @param request validated form DTO
     * @param result binding result containing validation errors
     * @param session current HTTP session
     * @param model model used to return error state to the view
     * @return redirect to created blog or re-rendered form on error
     */
    @PostMapping("/add")
    public String addBlog(@Valid @ModelAttribute("blog") BlogRequest request, BindingResult result, HttpSession session,
            Model model) {

        if (result.hasErrors()) {
            return "add-blog"; // validation failed — show form again with field errors
        }
        try {
            User owner = requireLogin(session); // enforce authentication
            BlogResponse created = blogService.create(request, owner); // delegate creation
            return "redirect:/blogs/" + created.getId(); // redirect to the new blog
        } catch (Exception ex) {
            // Catch service-layer errors (e.g., validation/uniqueness) and show them to the user
            model.addAttribute("error", ex.getMessage());
            return "add-blog";
        }
    }

    /**
     * View a single active blog.
     *
     * <p>Loads an active (non-deleted) blog via the service and places the DTO into the model.
     *
     * @param id blog id path variable
     * @param model model for the view
     * @return view name for displaying a blog
     */
    @GetMapping("/{id}")
    public String viewBlog(@PathVariable Long id, Model model) {
        BlogResponse blog = blogService.getActiveById(id); // may throw ResourceNotFoundException if not found
        model.addAttribute("blog", blog);
        return "view-blog";
    }

    /**
     * Render the edit page for a blog.
     *
     * <p>Requires the user to be authenticated and to own the blog. Pre-populates
     * a BlogRequest DTO with existing values for the form.
     *
     * @param id blog id path variable
     * @param session HTTP session used to identify the caller
     * @param model model used to populate form backing objects and attributes
     * @return view name for editing or throws UnauthorizedException when not owner
     */
    @GetMapping("/{id}/edit")
    public String editBlogPage(@PathVariable Long id, HttpSession session, Model model) {
        User owner = requireLogin(session); // ensure logged in
        BlogResponse blog = blogService.getActiveById(id); // fetch blog
        if (!blog.getUserId().equals(owner.getId()))
            throw new UnauthorizedException("Only owner can edit"); // enforce ownership

        // Populate form DTO with existing values to display in the edit form
        BlogRequest req = new BlogRequest();
        req.setTitle(blog.getTitle());
        req.setShortDescription(blog.getShortDescription());
        req.setContent(blog.getContent());

        model.addAttribute("blogId", id);
        model.addAttribute("blog", req);
        return "edit-blog";
    }

    /**
     * Handle edit form submission.
     *
     * <p>Validates input, enforces authentication, delegates update to the service
     * which again enforces ownership; on success redirects to the updated blog.
     *
     * @param id blog id path variable
     * @param request validated edit DTO
     * @param result binding result with validation errors
     * @param session current HTTP session
     * @param model used to return error state to the view
     * @return redirect to blog view or re-rendered edit form on error
     */
    @PostMapping("/{id}/edit")
    public String editBlog(@PathVariable Long id, @Valid @ModelAttribute("blog") BlogRequest request,
            BindingResult result, HttpSession session, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("blogId", id);
            return "edit-blog"; // validation failure — show form with errors
        }

        try {
            User owner = requireLogin(session); // ensure authenticated
            blogService.update(id, request, owner); // delegate update (service enforces ownership)
            return "redirect:/blogs/" + id;
        } catch (Exception ex) {
            // Show error returned from service (e.g., not found, not owner, uniqueness violation)
            model.addAttribute("error", ex.getMessage());
            model.addAttribute("blogId", id);
            return "edit-blog";
        }
    }

    /**
     * Soft-delete a blog.
     *
     * <p>Requires authentication and ownership. Delegates to service to mark the blog
     * as deleted and redirects to home. Uses POST to perform a state-changing action.
     *
     * @param id blog id to delete
     * @param session current HTTP session for authentication
     * @return redirect to home after deletion
     */
    @PostMapping("/{id}/delete")
    public String deleteBlog(@PathVariable Long id, HttpSession session) {
        User owner = requireLogin(session); // enforce authenticated user
        blogService.softDelete(id, owner); // service enforces ownership and performs soft-delete
        return "redirect:/";
    }

    /**
     * AJAX endpoint used by the client to validate title uniqueness.
     *
     * <p>Returns true when the supplied title is unique (optionally excluding the provided blogId).
     * Annotated with @ResponseBody to return JSON boolean.
     *
     * @param title title to validate
     * @param blogId optional blog id to exclude from uniqueness check
     * @return HTTP 200 with boolean body indicating uniqueness
     */
    @GetMapping("/validate/title")
    @ResponseBody
    public ResponseEntity<Boolean> validateTitle(@RequestParam String title,
            @RequestParam(required = false) Long blogId) {
        return ResponseEntity.ok(blogService.isTitleUnique(title, blogId));
    }

    /**
     * List the logged-in user's published blogs with pagination.
     *
     * <p>Requires authentication. Uses page request parameter (zero-based) and a fixed page size.
     * Places content, currentPage and totalPages into the model for the view template to render.
     *
     * @param page zero-based page index defaulting to 0
     * @param session HTTP session to identify the logged-in user
     * @param model model used to expose paged results and pagination metadata to the view
     * @return view name rendering the user's blogs
     */
    @GetMapping("/my-blogs")
    public String myBlogs(@RequestParam(defaultValue = "0") int page, HttpSession session, Model model) {
        User owner = requireLogin(session); // ensure caller is authenticated
        Page<Blog> blogs = blogService.getPublishedBlogsByUser(owner.getId(), page, 10); // fixed page size of 10
        model.addAttribute("blogs", blogs.getContent()); // pass current page content
        model.addAttribute("currentPage", page); // current page index for the view
        model.addAttribute("totalPages", blogs.getTotalPages()); // total pages for pagination UI
        return "my-blogs";
    }
}
