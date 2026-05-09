package in.ansari.auth.service;

import in.ansari.auth.dto.LoginRequest;
import in.ansari.auth.dto.LoginResponse;
import in.ansari.auth.dto.LogoutRequest;
import in.ansari.auth.dto.LogoutResponse;
import in.ansari.auth.dto.RefreshTokenRequest;
import in.ansari.auth.dto.RefreshTokenResponse;
import in.ansari.auth.entity.RefreshToken;
import in.ansari.auth.entity.User;
import in.ansari.auth.repository.RefreshTokenRepository;
import in.ansari.auth.repository.UserRepository;
import in.ansari.auth.security.jwt.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RefreshTokenRepository refreshTokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    public AuthServiceImpl(
            UserRepository userRepository,
            RefreshTokenRepository refreshTokenRepository,
            PasswordEncoder passwordEncoder,
            JwtUtil jwtUtil
    ) {
        this.userRepository = userRepository;
        this.refreshTokenRepository = refreshTokenRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        User user = userRepository
                .findByTenantIdAndUsernameAndIsDeletedFalse(
                        request.getTenantId(),
                        request.getUsername()
                )
                .orElseThrow(() ->
                        new RuntimeException("User not found")
                );

        if (!passwordEncoder.matches(
                request.getPassword(),
                user.getPassword()
        )) {
            throw new RuntimeException("Invalid credentials");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("tenantId", user.getTenantId());
        claims.put("role", user.getRole().name());

        String accessToken =
                jwtUtil.generateAccessToken(user.getUsername(), claims);

        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUser(user);
        refreshToken.setToken(UUID.randomUUID().toString());
        refreshToken.setExpiryDate(
        	    LocalDateTime.now().plusDays(7)
        );
        refreshToken.setRevoked(false);

        refreshTokenRepository.save(refreshToken);

        return new LoginResponse(
                accessToken,
                refreshToken.getToken(),
                900
        );
    }
    
    @Transactional
    @Override
    public RefreshTokenResponse refresh(RefreshTokenRequest request) {

        RefreshToken refreshToken = refreshTokenRepository
                .findByTokenAndRevokedFalse(request.getRefreshToken())
                .orElseThrow(() ->
                        new RuntimeException("Invalid refresh token")
                );

        if (refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Refresh token expired");
        }

        User user = refreshToken.getUser();

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("tenantId", user.getTenantId());
        claims.put("role", user.getRole().name());

        String newAccessToken =
                jwtUtil.generateAccessToken(user.getUsername(), claims);

        return new RefreshTokenResponse(newAccessToken, 900);
    }
    
    @Transactional
    @Override
    public LogoutResponse logout(LogoutRequest request) {

        RefreshToken refreshToken = refreshTokenRepository
                .findByTokenAndRevokedFalse(request.getRefreshToken())
                .orElseThrow(() ->
                        new RuntimeException("Invalid refresh token")
                );

        refreshToken.setRevoked(true);
        refreshTokenRepository.save(refreshToken);

        return new LogoutResponse("Logout successful");
    }
}