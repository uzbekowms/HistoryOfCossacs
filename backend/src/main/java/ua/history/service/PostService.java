package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.history.dto.PostRequest;
import ua.history.factory.PostFactory;
import ua.history.model.Post;
import ua.history.model.PostType;
import ua.history.repository.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    private final ResourceService resourceService;

    private final Map<String, String> fileTypes = Map.of("Аудіоматеріали", ".mp3", "Відеоматеріали", ".mp4");

    public List<Post> getAll() {
        System.out.println(postRepository.findAll());
        return postRepository.findAll(Sort.by(Sort.Direction.ASC, "dateStart"));
    }

    public Post getById(int id) {
        return postRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot get post. Post not found with id: " + id));
    }


    public Post save(PostRequest post) {
        Post postToSave = PostFactory.fromDto(post);
        return postRepository.save(postToSave);
    }


    public Post update(int id, PostRequest post) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot update post. Post not found");

        Post postToSave = PostFactory.fromDto(post);

        return postRepository.save(postToSave);
    }

    public boolean delete(int id) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot delete post. Post not found with id: " + id);

        postRepository.deleteById(id);
        return true;
    }

    public List<Post> findAll(PostType category) {
        return postRepository.findAll(category, Sort.by(Sort.Direction.ASC, "dateStart"));
    }
}
