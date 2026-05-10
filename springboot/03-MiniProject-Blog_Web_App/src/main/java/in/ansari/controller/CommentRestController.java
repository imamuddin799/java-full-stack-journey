package in.ansari.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ansari.dto.CommentRequest;
import in.ansari.dto.CommentResponse;
import in.ansari.exception.UnauthorizedException;
import in.ansari.service.CommentService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

/**
 * REST controller exposing comment-related API endpoints used by client-side code.
 *
 * <p>Responsibilities:
 * - List comments for a blog (public).
 * - Create comments (accepts JSON payload, validates input, returns created DTO).
 * - Delete comments with server-side authorization checks (only blog owner may delete).
 *
 * Design notes:
 * - Uses HttpSession for lightweight authentication state (USER_ID). In larger systems prefer a token-based approach.
 * - Input validation errors are returned as a map of field -> message to support client-side form display.
 * - Deletion endpoints validate authentication and delegate ownership checks to the service layer.
 * - Controller methods remain thin: they perform transport concerns and basic validation, delegating business logic to CommentService.
 */
@RestController // @RestController combines @Controller and @ResponseBody for JSON APIs
@RequestMapping("/comments") // Base path for all endpoints in this controller
public class CommentRestController {

    // Service responsible for comment business logic; injected through constructor
    private final CommentService commentService;

    public CommentRestController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * Helper to read the logged-in user's id from the HTTP session.
     *
     * <p>Returns null when no user id is present; callers should check and respond appropriately.
     *
     * @param session current HTTP session
     * @return user id from session or null if not authenticated
     */
    private Long getUserId(HttpSession session) {
        return (Long) session.getAttribute("USER_ID");
    }

    /**
     * List comments for a specific blog.
     *
     * <p>Public endpoint that returns a list of CommentResponse DTOs for the given blog id.
     * Delegates to the service which maps entities to DTOs and enforces ordering.
     *
     * @param blogId id of the blog whose comments are requested
     * @return 200 OK with list of CommentResponse objects
     */
    @GetMapping("/{blogId}")
    public ResponseEntity<List<CommentResponse>> list(@PathVariable Long blogId) {
        return ResponseEntity.ok(commentService.listByBlog(blogId));
    }

    /**
     * Add a comment to a blog.
     *
     * <p>Accepts a JSON payload and validates it with Jakarta Bean Validation. If there are field errors,
     * returns 400 with a map of field->message to let the client show inline errors. Otherwise delegates
     * to the service to persist the comment and return the created DTO.
     *
     * Security/validation notes:
     * - The endpoint allows anonymous comments when no session user is present; logged-in user id is passed
     *   to the service for possible future association but is optional.
     * - Consider rate limiting and spam/malicious content filtering in the service for public comment endpoints.
     *
     * @param blogId id of the blog to attach the comment to
     * @param request validated request body containing name, email, commentText
     * @param result binding result that contains validation errors (if any)
     * @param session HTTP session used to optionally identify the commenter
     * @return 200 OK with created CommentResponse or 400 Bad Request with field errors
     */
    @PostMapping("/{blogId}")
    public ResponseEntity<?> add(@PathVariable Long blogId, @Valid @RequestBody CommentRequest request,
            BindingResult result, HttpSession session) {

        // If validation failed, return a simple field->message map for client-side consumption
        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            result.getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors);
        }

        Long uid = getUserId(session); // may be null for anonymous commenters
        return ResponseEntity.ok(commentService.addComment(blogId, request, uid));
    }

    /**
     * Delete a comment given blog and comment ids.
     *
     * <p>Performs a session check and then delegates to the service which re-checks ownership
     * and deletes the comment. Returns 204 No Content on success.
     *
     * Security notes:
     * - The presence of blogId in the path is primarily for routing symmetry with clients; ownership
     *   is re-validated on the server using the comment's parent blog stored in the database.
     *
     * @param blogId id of the blog (provided for client clarity; not used for authorization in the controller)
     * @param commentId id of the comment to delete
     * @param session HTTP session used to identify the caller
     * @return 204 No Content on success, or throws UnauthorizedException when not authenticated
     */
    @DeleteMapping("/{blogId}/{commentId}")
    public ResponseEntity<Void> delete(@PathVariable Long blogId, @PathVariable Long commentId, HttpSession session) {
        Long uid = getUserId(session);
        if (uid == null) {
            throw new UnauthorizedException("Provide credentials to delete");
        }
        commentService.deleteCommentIfOwnedBlog(commentId, uid);
        return ResponseEntity.noContent().build();
    }

    /**
     * Alternative delete endpoint that only accepts the comment id and uses the logged-in user for authorization.
     *
     * <p>Functionally identical to the other delete endpoint but sometimes used by UI flows that only have
     * the comment id available. Delegates authorization checks to the service.
     *
     * @param commentId id of the comment to delete
     * @param session current HTTP session used to identify the caller
     * @return 204 No Content on success, or throws UnauthorizedException when not authenticated
     */
    @DeleteMapping("/owner/{commentId}")
    public ResponseEntity<Void> deleteByBlogOwner(@PathVariable Long commentId, HttpSession session) {
        Long uid = getUserId(session);
        if (uid == null) {
            throw new UnauthorizedException("Provide credentials to delete");
        }
        commentService.deleteCommentIfOwnedBlog(commentId, uid);
        return ResponseEntity.noContent().build();
    }
}
