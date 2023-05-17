package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.history.dto.PostRequest;
import ua.history.factory.PostFactory;
import ua.history.model.Post;
import ua.history.repository.PostRepository;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    ResourceService resourceService;

    public List<Post> getAll() {
        return postRepository.findAll();
    }

    public Post getById(int id) {
        return postRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot get post. Post not found with id: " + id));
    }

    public Post save(PostRequest post) {
        String fileName = resourceService.writeFile(post.getPostFile());
        Post postToSave = PostFactory.fromDto(post, fileName);

        return postRepository.save(postToSave);
    }

    public Post update(int id, PostRequest post) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot update post. Post not found");

        return this.save(post);
    }

    public boolean delete(int id) {
        if (!postRepository.existsById(id))
            throw new EntityNotFoundException("Cannot delete post. Post not found with id: " + id);

        postRepository.deleteById(id);
        return true;
    }
}
