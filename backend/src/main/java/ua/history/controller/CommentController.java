package ua.history.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.history.dto.PostCommentDTO;
import ua.history.model.PostComment;
import ua.history.service.CommentService;

import javax.swing.text.html.parser.Entity;

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

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable int id){
        return ResponseEntity.ok(commentService.delete(id));
    }
}
