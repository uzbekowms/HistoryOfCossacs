package ua.history.dto;

import jakarta.validation.constraints.NotBlank;
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


    private PostType postType;

    private Date dateStart;

    private Date dateEnd;

    private String pathToFile;



}
