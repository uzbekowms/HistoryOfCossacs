package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ua.history.dto.PostCommentDTO;
import ua.history.factory.PostCommentFactory;
import ua.history.model.PostComment;
import ua.history.repository.CommentRepository;

@Service
public class CommentService {

    public CommentService(CommentRepository commentRepository, PostCommentFactory commentFactory) {
        this.commentRepository = commentRepository;
        this.commentFactory = commentFactory;
    }

    private final CommentRepository commentRepository;

    private final PostCommentFactory commentFactory;

    public PostComment getComment(int id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Cannot find comment. Not found comment with id: " + id));
    }

    public PostComment add(PostCommentDTO postCommentDTO) {
        PostComment postComment = commentFactory.fromDto(postCommentDTO);
        return commentRepository.save(postComment);
    }

    public boolean delete(int id) {
        if (!commentRepository.existsById(id))
            throw new EntityNotFoundException("Cannot delete. Not found comment with id: " + id);

        commentRepository.deleteById(id);
        return true;
    }
}
