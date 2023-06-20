package ua.history.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ua.history.dto.ChatMessageDTO;
import ua.history.factory.MessageFactory;
import ua.history.model.ChatMessage;
import ua.history.repository.ChatMessageRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final MessageFactory messageFactory;

    public ChatMessageDTO save(ChatMessageDTO chatMessageDTO) {
        return messageFactory.toDto(chatMessageRepository.save(messageFactory.fromDto(chatMessageDTO)));
    }

    public List<ChatMessageDTO> findAll() {
        return chatMessageRepository.findAll(Sort.by(Sort.Direction.DESC, "timestamp")).stream().map(messageFactory::toDto).toList();
    }
}
