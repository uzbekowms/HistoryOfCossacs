package ua.history.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import ua.history.dto.PostRequest;
import ua.history.model.Post;

public class PostFactory {

    public static Post fromDto(PostRequest postRequest) {
        return Post.builder()
                .id(postRequest.getId())
                .title(postRequest.getTitle())
                .description(postRequest.getDescription())
                .postType(postRequest.getPostType())
                .dateStart(postRequest.getDateStart())
                .dateEnd(postRequest.getDateEnd())
                .previewImagePath(postRequest.getPathToFile())
                //.previewImagePath(postRequest.getPostFile().getName())
                .build();
    }

    public static Post fromDto(PostRequest postRequest, String fileName) {
        return Post.builder()
                .id(postRequest.getId())
                .title(postRequest.getTitle())
                .description(postRequest.getDescription())
                .postType(postRequest.getPostType())
                .dateStart(postRequest.getDateStart())
                .dateEnd(postRequest.getDateEnd())
                .previewImagePath(fileName)
                .build();
    }

}
