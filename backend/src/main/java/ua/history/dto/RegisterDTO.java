package ua.history.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {
    @NotBlank(message = "Імя не може бути порожнім")
    private String nickname;
    @NotBlank(message = "Електрона адреса не може бути порожньою")
    @Email(message = "Електрона адреса некоректна")
    private String email;
    @NotBlank(message = "Пароль не може бути порожнім")
    private String password;
}
