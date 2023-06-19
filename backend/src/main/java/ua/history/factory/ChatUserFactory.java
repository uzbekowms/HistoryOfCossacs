package ua.history.factory;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.history.dto.MessageUserDTO;
import ua.history.model.User;
import ua.history.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class ChatUserFactory {

    private final UserRepository userRepository;

    public User fromDto(MessageUserDTO user) {
        User userFromDb = userRepository.findById(user.getId())
                .orElseThrow(() -> new EntityNotFoundException("Не вдалось знайти користувача з ідентифікатором: " + user.getId()));
        return User.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .profilePicturePath(user.getProfilePicturePath())
                .email(userFromDb.getEmail())
                .password(userFromDb.getPassword())
                .build();
    }

    public MessageUserDTO toDto(User user) {
        return MessageUserDTO.builder()
                .id(user.getId())
                .nickname(user.getNickname())
                .profilePicturePath(user.getProfilePicturePath())
                .build();
    }
}
