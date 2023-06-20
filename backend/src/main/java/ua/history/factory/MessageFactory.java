package ua.history.factory;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.history.dto.ChatMessageDTO;
import ua.history.model.ChatMessage;
import ua.history.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class MessageFactory {
    private final ChatUserFactory chatUserFactory;
    private final UserRepository userRepository;

    public ChatMessage fromDto(ChatMessageDTO message) {
        return ChatMessage.builder()
                .id(message.getId())
                .sender(userRepository.findById(message.getSender().getId()).orElseThrow(() -> new EntityNotFoundException("Не можливо знайти користувача з ідентифікатором: " + message.getSender().getId())))
                .message(message.getMessage())
                .timestamp(message.getTimestamp())
                .build();
    }

    public ChatMessageDTO toDto(ChatMessage save) {
        return ChatMessageDTO
                .builder()
                .id(save.getId())
                .message(save.getMessage())
                .timestamp(save.getTimestamp())
                .sender(chatUserFactory.toDto(save.getSender()))
                .build();
    }
}
