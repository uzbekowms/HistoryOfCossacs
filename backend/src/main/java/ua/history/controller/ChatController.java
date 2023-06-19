package ua.history.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import ua.history.dto.ChatMessageDTO;
import ua.history.model.ChatMessage;
import ua.history.service.ChatMessageService;

@Controller
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatMessageService chatMessageService;
    @MessageMapping("/chat")
    public void processMessage(@Payload ChatMessageDTO message){

    }
}
