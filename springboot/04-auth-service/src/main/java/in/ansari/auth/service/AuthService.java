package in.ansari.auth.service;

import in.ansari.auth.dto.LoginRequest;
import in.ansari.auth.dto.LoginResponse;
import in.ansari.auth.dto.LogoutRequest;
import in.ansari.auth.dto.LogoutResponse;
import in.ansari.auth.dto.RefreshTokenRequest;
import in.ansari.auth.dto.RefreshTokenResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);
    RefreshTokenResponse refresh(RefreshTokenRequest request);
    LogoutResponse logout(LogoutRequest request);
}