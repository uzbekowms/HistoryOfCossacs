package ua.history.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.history.model.Post;
import ua.history.service.FavoritesService;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoritesController {

    private final FavoritesService favoritesService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Post>> getUserFavorites(@PathVariable int id){
        return ResponseEntity.ok(favoritesService.findAll(id));
    }

    @PostMapping("/{id}/{post_id}")
    public ResponseEntity<Post> addFavorite(@PathVariable int id, @PathVariable("post_id") int postId) {
        return ResponseEntity.ok(favoritesService.save(id, postId));
    }

    @DeleteMapping("/{id}/{post_id}")
    public ResponseEntity<String> removeFavorite(@PathVariable int id, @PathVariable("post_id") int postId) {
        return ResponseEntity.ok(favoritesService.delete(id, postId));
    }
}
