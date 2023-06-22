package ua.history.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.history.dto.UserFeedbackDTO;
import ua.history.model.UserFeedback;
import ua.history.service.UserFeedbackService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feedbacks")
public class FeedbackController {

    private final UserFeedbackService feedbackService;

    @GetMapping
    public ResponseEntity<List<UserFeedback>> getFeedbacks(){
        return ResponseEntity.ok(feedbackService.findAll());
    }
    @PostMapping
    public ResponseEntity<UserFeedback> addFeedback(@RequestBody UserFeedbackDTO feedback){
        return ResponseEntity.ok(feedbackService.save(feedback));
    }
}
