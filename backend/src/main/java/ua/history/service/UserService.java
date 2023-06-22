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
        User user = userRepository.findByEmail(authDTO.getEmail()).orElseThrow(() -> new EntityNotFoundException("Неправильний логін або пароль"));
        if (!passwordEncoder.matches(authDTO.getPassword(), user.getPassword()))
            throw new EntityNotFoundException("Неправильний логін або пароль");
        return userFactory.toDto(user);
    }

    public UserDTO signup(RegisterDTO registerDTO) {
        if (userRepository.existsByEmail(registerDTO.getEmail()))
            throw new UserAlreadyExistsException("Електрона адреса вже зайнята");

        User userToSave = userFactory.fromDto(registerDTO);
        return userFactory.toDto(userRepository.save(userToSave));
    }

    public User update(UserDTO user, int id) {
        User userFromDb = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Не вдалось знайти користувача з ідентифікатором: " + id));

        userFromDb.setEmail(user.getEmail());
        userFromDb.setRole(user.getRole());
        userFromDb.setNickname(user.getNickname());
        userFromDb.setEmail(user.getEmail());
        userFromDb.setPassword(user.getPassword() != null ? passwordEncoder.encode(user.getPassword()) : userFromDb.getPassword());

        return userRepository.save(userFromDb);
    }
}
