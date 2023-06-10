package ua.history.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.history.dto.PostRequest;
import ua.history.model.Post;
import ua.history.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }


    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable int id) {
        return ResponseEntity.ok(postService.getById(id));
    }

    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        return ResponseEntity.ok(postService.getAll());
    }

    /* @PostMapping()
     public ResponseEntity<Post> savePost(@RequestPart(value = "post") PostRequest post) {
         System.out.println(post);
         return ResponseEntity.ok(postService.save(post));
     }*/
    @PostMapping
    public ResponseEntity<Post> savePost(@RequestBody PostRequest post) {
        System.out.println(post);
        return ResponseEntity.ok(postService.save(post));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable int id, @RequestPart("post") PostRequest post) {
        return ResponseEntity.ok(postService.update(id, post));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deletePost(@PathVariable int id) {
        return ResponseEntity.ok(postService.delete(id));
    }
}
