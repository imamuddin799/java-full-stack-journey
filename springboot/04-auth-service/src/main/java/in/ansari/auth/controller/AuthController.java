package in.ansari.auth.controller;

import in.ansari.auth.dto.LoginRequest;
import in.ansari.auth.dto.LoginResponse;
import in.ansari.auth.dto.LogoutRequest;
import in.ansari.auth.dto.LogoutResponse;
import in.ansari.auth.dto.RefreshTokenRequest;
import in.ansari.auth.dto.RefreshTokenResponse;
import in.ansari.auth.service.AuthService;
import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authService.login(request);
    }
    
    @PostMapping("/refresh")
    public RefreshTokenResponse refresh(
            @Valid @RequestBody RefreshTokenRequest request
    ) {
        return authService.refresh(request);
    }
    
    @PostMapping("/logout")
    public ResponseEntity<LogoutResponse> logout(
            @RequestBody LogoutRequest request) {

        return ResponseEntity.ok(authService.logout(request));
    }
}