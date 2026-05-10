package in.ansari.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import in.ansari.entity.Comment;
import in.ansari.service.CommentService;

/**
 * MVC controller for owner-facing comment management pages.
 *
 * <p>Provides a paginated view where a blog owner can see comments made on all of their blogs.
 * This controller relies on a simple session-based authentication model (USER_ID stored in session).
 *
 * Design notes:
 * - Keeps controller responsibilities narrow: read session, call service, and prepare model for the view.
 * - Delegates business logic, authorization and pagination behavior to CommentService.
 * - Uses redirect to /login when the user is not authenticated to protect the page from anonymous access.
 */
@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    // Constructor injection for easier testing and to express required dependency
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Display a paginated list of comments that appear on blogs owned by the current user.
     *
     * <p>Behavior:
     * - Reads USER_ID from the HTTP session; if absent, redirects to the login page.
     * - Calls CommentService.getCommentsOnUserBlogs to obtain a Page<Comment>.
     * - Exposes page content and pagination metadata to the view model: comments, currentPage, totalPages.
     *
     * Security and UX notes:
     * - The controller trusts the session USER_ID; ensure session management is secure (HTTP-only cookie, CSRF protection).
     * - The page parameter is zero-based to align with Spring Data Pageable conventions.
     * - Consider adding explicit authorization checks or reloading the User entity if more information is required.
     *
     * @param page zero-based page index (optional, defaults to 0)
     * @param session HTTP session containing authentication state
     * @param model model used to pass attributes to the view template
     * @return view name "my-comments" or redirect to login when unauthenticated
     */
    @GetMapping("/my-comments")
    public String myComments(@RequestParam(defaultValue = "0") Integer page, HttpSession session, Model model) {
        // Read the user id from session; null means not logged in
        Long userId = (Long) session.getAttribute("USER_ID");
        if (userId == null)
            return "redirect:/login"; // Protect the page — require authentication

        // Retrieve a page of comments for the user's blogs; page size fixed at 10
        Page<Comment> comments = commentService.getCommentsOnUserBlogs(userId, page, 10);

        // Add the page content and pagination metadata to the model for template rendering
        model.addAttribute("comments", comments.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", comments.getTotalPages());

        // Render the view (e.g., templates/my-comments.html)
        return "my-comments";
    }
}
