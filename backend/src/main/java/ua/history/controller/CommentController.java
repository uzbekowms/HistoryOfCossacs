package ua.history.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.history.dto.PostCommentDTO;
import ua.history.model.PostComment;
import ua.history.service.CommentService;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public PostComment addComment(@RequestBody PostCommentDTO postCommentDTO){
        return commentService.add(postCommentDTO);
    }
}
