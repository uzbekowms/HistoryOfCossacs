package ua.history.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.history.dto.UserFeedbackDTO;
import ua.history.factory.FeedbackFactory;
import ua.history.model.UserFeedback;
import ua.history.repository.UserFeedbackRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserFeedbackService {
    private final FeedbackFactory feedbackFactory;
    private final UserFeedbackRepository repository;

    public UserFeedback save(UserFeedbackDTO feedback) {
        return repository.save(feedbackFactory.fromDto(feedback));
    }

    public List<UserFeedback> findAll() {
        return repository.findAll(Sort.by(Sort.Direction.DESC, "dateOfFeedback"));
    }
}
