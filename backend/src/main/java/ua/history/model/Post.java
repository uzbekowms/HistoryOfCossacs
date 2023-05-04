package ua.history.model;

import jakarta.persistence.*;
import lombok.Data;

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

    @Enumerated(value = EnumType.STRING)
    private PostType postType;
}
