package ua.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.history.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
