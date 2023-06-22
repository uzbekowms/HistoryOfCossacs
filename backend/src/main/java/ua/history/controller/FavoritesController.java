package ua.history.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.history.model.Post;
import ua.history.service.FavoritesService;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoritesController {

    private final FavoritesService favoritesService;

    @PostMapping("/{id}/{post_id}")
    public ResponseEntity<Post> addFavorite(@PathVariable int id, @PathVariable("post_id") int postId) {
        return ResponseEntity.ok(favoritesService.save(id, postId));
    }

    @DeleteMapping("/{id}/{post_id}")
    public ResponseEntity<String> removeFavorite(@PathVariable int id, @PathVariable("post_id") int postId) {
        return ResponseEntity.ok(favoritesService.delete(id, postId));
    }
}
