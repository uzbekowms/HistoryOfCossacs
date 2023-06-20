package ua.history.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import ua.history.dto.AuthDTO;
import ua.history.dto.RegisterDTO;
import ua.history.dto.UserDTO;
import ua.history.model.User;

@Component
@RequiredArgsConstructor
public class UserFactory {

    private final PasswordEncoder passwordEncoder;

    public User fromDto(RegisterDTO registerDTO) {
        return User.builder()
                .nickname(registerDTO.getNickname())
                .email(registerDTO.getEmail())
                .password(passwordEncoder.encode(registerDTO.getPassword()))
                .role("ROLE_USER")
                .build();
    }


    public UserDTO toDto(User save) {
        return UserDTO.builder()
                .id(save.getId())
                .email(save.getEmail())
                .nickname(save.getNickname())
                .profilePicturePath(save.getProfilePicturePath())
                .build();
    }
}
