package ua.history.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.history.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    Optional<User> findByEmailAndPassword(String email, String password);
}
