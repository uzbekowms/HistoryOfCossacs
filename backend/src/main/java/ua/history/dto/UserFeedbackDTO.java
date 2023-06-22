package ua.history.dto;


import lombok.*;
import ua.history.model.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserFeedbackDTO {
    private int id;

    private int userId;

    private String message;
}
