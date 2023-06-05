package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ua.history.dto.PostRequest;
import ua.history.factory.PostFactory;
import ua.history.model.Post;
import ua.history.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    private final ResourceService resourceService;

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


    public Post save(PostRequest post, MultipartFile file) {
        Post postToSave = PostFactory.fromDto(post);
        String filename = resourceService.writeFile(file);
        postToSave.setPreviewImagePath(filename);
        return postRepository.save(postToSave);
    }

    public Post update(int id, PostRequest post, MultipartFile file) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot update post. Post not found");

        Post postToSave = PostFactory.fromDto(post);
        resourceService.updateFile(file, postToSave.getPreviewImagePath());

        return postRepository.save(postToSave);
    }

    public boolean delete(int id) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot delete post. Post not found with id: " + id);

        postRepository.deleteById(id);
        return true;
    }
}
