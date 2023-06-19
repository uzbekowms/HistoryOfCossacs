package ua.history.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.history.dto.AuthDTO;
import ua.history.dto.RegisterDTO;
import ua.history.dto.UserDTO;
import ua.history.exception.UserAlreadyExistsException;
import ua.history.factory.UserFactory;
import ua.history.model.User;
import ua.history.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserFactory userFactory;
    private final PasswordEncoder passwordEncoder;


    public User getById(int id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Cannot find user with id: " + id));
    }

    public UserDTO login(AuthDTO authDTO) {
        User user = userRepository
                .findByEmailAndPassword(authDTO.getEmail(),
                        passwordEncoder.encode(authDTO.getPassword()))
                .orElseThrow(() -> new EntityNotFoundException("Неправильний логін або пароль"));

        return userFactory.toDto(user);
    }

    public UserDTO signup(RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail()))
            throw new UserAlreadyExistsException("Електрона адреса вже зайнята");

        User userToSave = userFactory.fromDto(registerDTO);
        return userFactory.toDto(userRepository.save(userToSave));
    }
}
