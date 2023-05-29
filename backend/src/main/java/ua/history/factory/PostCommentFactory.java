package ua.history.factory;


import org.springframework.stereotype.Service;
import ua.history.dto.PostCommentDTO;
import ua.history.model.PostComment;
import ua.history.service.PostService;
import ua.history.service.UserService;

@Service
public class PostCommentFactory {

    private final PostService postService;

    private final UserService userService;


    public PostCommentFactory(PostService postService, UserService userService) {
        this.postService = postService;
        this.userService = userService;
    }

    public PostCommentDTO toDto(PostComment postComment) {
        return PostCommentDTO.builder()
                .id(postComment.getId())
                .postId(postComment.getPost().getId())
                .ownerId(postComment.getOwner().getId())
                .comment(postComment.getComment())
                .timeOfPublish(postComment.getTimestamp())
                .build();

    }

    public PostComment fromDto(PostCommentDTO postComment) {
        return PostComment.builder()
                .id(postComment.getId())
                .post(postService.getById(postComment.getPostId()))
                .owner(userService.getById(postComment.getOwnerId()))
                .comment(postComment.getComment())
                .timestamp(postComment.getTimeOfPublish())
                .build();
    }
}
