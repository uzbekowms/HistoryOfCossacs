package ua.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.history.model.PostComment;

@Repository
public interface CommentRepository extends JpaRepository<PostComment, Integer> {
}
