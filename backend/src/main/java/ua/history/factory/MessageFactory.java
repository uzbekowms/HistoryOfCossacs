package ua.history.factory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ua.history.dto.ChatMessageDTO;
import ua.history.model.ChatMessage;

@Component
@RequiredArgsConstructor
public class MessageFactory {
    private final ChatUserFactory chatUserFactory;

    public ChatMessage fromDto(ChatMessageDTO message) {
        return ChatMessage.builder()
                .id(message.getId())
                .sender(chatUserFactory.fromDto(message.getSender()))
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
