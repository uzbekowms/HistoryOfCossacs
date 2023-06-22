package ua.history.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "user_feedbacks")
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class UserFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    private String message;

    @Column(name = "date_of_feedback", columnDefinition = "")
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime dateOfFeedback;

}
