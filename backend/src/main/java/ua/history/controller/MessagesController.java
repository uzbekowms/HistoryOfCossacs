package ua.history.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.history.dto.ChatMessageDTO;
import ua.history.service.ChatMessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessagesController {

    private final ChatMessageService messageService;

    @GetMapping
    public ResponseEntity<List<ChatMessageDTO>> getAllMessages(){
        return ResponseEntity.ok(messageService.findAll());
    }
}
