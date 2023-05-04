package ua.history.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(columnDefinition = "TEXT NOT NULL")
    private String description;

    @Column(name = "preview_image_path")
    private String previewImagePath;

    @Enumerated(value = EnumType.STRING)
    private PostType postType;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;
}
