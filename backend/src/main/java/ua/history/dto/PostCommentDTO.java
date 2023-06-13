package ua.history.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentDTO {
    private int id;

    @NotNull(message = "Post id cannot be null")
    private int postId;
    @NotNull(message = "Owner id cannot be null")
    private int ownerId;
    @NotBlank(message = "Comment cant be blank")
    private String comment;

    private Date timeOfPublish;
}