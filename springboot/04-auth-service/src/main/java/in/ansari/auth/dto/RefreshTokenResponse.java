package in.ansari.auth.dto;

import lombok.Getter;

@Getter
public class RefreshTokenResponse {

    private String accessToken;
    private String tokenType = "Bearer";
    private long expiresIn;

    public RefreshTokenResponse(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}