package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import ua.history.model.User;
import ua.history.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getById(int id){
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find user with id: " + id));
    }
}
