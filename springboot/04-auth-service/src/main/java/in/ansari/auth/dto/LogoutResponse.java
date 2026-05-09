package in.ansari.auth.dto;

import lombok.Getter;

@Getter
public class LogoutResponse {
    private String message;
    public LogoutResponse(String message) {
    	this.message = message;
    }
}