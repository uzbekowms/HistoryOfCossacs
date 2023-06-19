package ua.history.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ua.history.dto.ChatMessageDTO;
import ua.history.factory.MessageFactory;
import ua.history.model.ChatMessage;
import ua.history.repository.ChatMessageRepository;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final MessageFactory messageFactory;

    public ChatMessageDTO save(ChatMessageDTO chatMessageDTO) {
        return messageFactory.toDto(chatMessageRepository.save(messageFactory.fromDto(chatMessageDTO)));
    }
}
