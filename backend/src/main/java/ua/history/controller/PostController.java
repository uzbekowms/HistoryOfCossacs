package ua.history.controller;

import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.history.model.Post;
import ua.history.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
@Setter
public class PostController {

    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAll());
    }

    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody Post post) {
        return ResponseEntity.ok(postService.save(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestBody Post post) {
        return ResponseEntity.ok(postService.update(id, post));
    }
}
