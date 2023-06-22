package ua.history.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Builder
@AllArgsConstructor
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "preview_image_path")
    private String previewImagePath;

    @Enumerated(value = EnumType.STRING)
    private PostType postType;

    @Column(name = "date_start")
    private Date dateStart;

    @Column(name = "date_end")
    private Date dateEnd;

    @OneToMany(mappedBy = "post")
    @JsonIgnoreProperties("post")
    @ToString.Exclude
    private List<PostComment> comments;

    @ManyToMany(mappedBy = "savedPosts")
    @JsonIgnore
    @ToString.Exclude
    private List<User> users;
}
