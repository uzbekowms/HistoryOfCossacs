package ua.history.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private int id;
    private String nickname;
    private String email;
    private String password;
    private String profilePicturePath;
    private String role;
}
