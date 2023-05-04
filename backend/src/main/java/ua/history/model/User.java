package ua.history.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nickname;

    private String email;

    private String password;

    @Column(name = "profile_picture")
    private String profilePictureName;


}
