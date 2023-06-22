package ua.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.history.model.UserFeedback;

public interface UserFeedbackRepository extends JpaRepository<UserFeedback, Integer> {
}
