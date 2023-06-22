package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.history.model.Post;
import ua.history.model.User;
import ua.history.repository.PostRepository;
import ua.history.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FavoritesService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;


    public Post save(int userId, int postId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new EntityNotFoundException("Неможливо знайти користувача з ідентифікатором: " + userId)
        );

        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new EntityNotFoundException("Неможливо знайти пост з ідентифікатором: " + postId));

        user.getSavedPosts().add(post);
        userRepository.save(user);
        return post;
    }

    public String delete(int userId, int postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new EntityNotFoundException("Неможливо знайти користувача з ідентифікатором: " + userId));

        user.getSavedPosts().removeIf(postToRemove -> postToRemove.getId() == postId);
        userRepository.save(user);
        return "Успішно видалено з обраних";
    }

    public List<Post> findAll(int id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Неможливо знайти користувача з ідентифікатором: " + id)
        );

        return user.getSavedPosts();
    }
}
