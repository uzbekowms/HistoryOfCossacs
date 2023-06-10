package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.history.dto.PostRequest;
import ua.history.factory.PostFactory;
import ua.history.model.Post;
import ua.history.repository.PostRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final ResourceService resourceService;

    private Map<String, String> fileTypes = Map.of("Аудіоматеріали", ".mp3", "Відеоматеріали", ".mp4");

    public PostService(PostRepository postRepository, ResourceService resourceService) {
        this.postRepository = postRepository;
        this.resourceService = resourceService;
    }

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getById(int id) {
        return postRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot get post. Post not found with id: " + id));
    }


    public Post save(PostRequest post) {
        Post postToSave = PostFactory.fromDto(post);
        String fileType = fileTypes.getOrDefault(postToSave.getPostType().getName(), ".png");
        //String filename = resourceService.writeFile(post.getPostFile());
        //postToSave.setPreviewImagePath(filename);
        return postRepository.save(postToSave);
    }



    public Post update(int id, PostRequest post) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot update post. Post not found");

        Post postToSave = PostFactory.fromDto(post);
        //resourceService.updateFile(post.getPostFile(), postToSave.getPreviewImagePath());

        return postRepository.save(postToSave);
    }

    public boolean delete(int id) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot delete post. Post not found with id: " + id);

        postRepository.deleteById(id);
        return true;
    }
}
