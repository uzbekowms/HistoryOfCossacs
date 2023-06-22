package ua.history.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.history.dto.UserFeedbackDTO;
import ua.history.model.UserFeedback;
import ua.history.repository.UserRepository;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class FeedbackFactory {

    private final UserRepository userRepository;

    public UserFeedback fromDto(UserFeedbackDTO feedback) {
        return UserFeedback.builder()
                .id(feedback.getId())
                .user(userRepository.findById(feedback.getUserId()).orElseThrow())
                .message(feedback.getMessage())
                .dateOfFeedback(LocalDateTime.now())
                .build();
    }

    public UserFeedback toDto(UserFeedback feedback) {
        return null;
    }
}
