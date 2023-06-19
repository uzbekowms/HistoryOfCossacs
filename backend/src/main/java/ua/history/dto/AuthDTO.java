package ua.history.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthDTO {
    @NotBlank(message = "Електрона адреса не може бути порожнью")
    private String email;
    @NotBlank(message = "Пароль не може бути порожнім")
    private String password;
}
