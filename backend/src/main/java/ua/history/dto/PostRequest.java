package ua.history.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;
import ua.history.model.PostType;

import java.util.Date;

@Data
public class PostRequest {

    private int id;
    @NotBlank(message = "Заголовок не може бути порожнім")
    private String title;

    private String description;

    @NotNull(message = "Файл поста не може бути порожнім")
    private MultipartFile postFile;

    private PostType postType;

    private Date dateStart;

    private Date dateEnd;
}
