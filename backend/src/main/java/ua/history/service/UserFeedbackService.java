package ua.history.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.history.dto.UserFeedbackDTO;
import ua.history.factory.FeedbackFactory;
import ua.history.model.UserFeedback;
import ua.history.repository.UserFeedbackRepository;

@Service
@RequiredArgsConstructor
public class UserFeedbackService {
    private final UserFeedbackRepository userFeedbackRepository;
    private final FeedbackFactory feedbackFactory;

    public UserFeedback save(UserFeedbackDTO feedback) {
        return feedbackFactory.fromDto(feedback);
    }

}
