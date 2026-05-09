package in.ansari.auth.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotNull
    private Long tenantId;

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}