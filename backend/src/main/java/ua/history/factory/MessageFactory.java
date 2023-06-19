package ua.history.factory;

import org.springframework.stereotype.Component;
import ua.history.dto.ChatMessageDTO;
import ua.history.model.ChatMessage;

@Component
public class MessageFactory {

    public ChatMessage fromDto(ChatMessageDTO message){
        return ChatMessage.builder()
                .id(message.getId())
                .sender(message.getSender())
                .build();
    }
}
