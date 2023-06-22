package ua.history.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.history.model.UserFeedback;
import ua.history.service.UserFeedbackService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final UserFeedbackService feedbackService;

    public ResponseEntity<List<UserFeedback>> getFeedbacks(){
        return ResponseEntity.ok(feedbackService.findAll());
    }
}
