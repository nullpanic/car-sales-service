package dev.nullpanic.messageservice.controller;

import dev.nullpanic.messageservice.dto.RequestMessageDto;
import dev.nullpanic.messageservice.service.SendBotMessageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("users")
public class UserController {
    private final SendBotMessageService sendBotMessageService;

    @PostMapping("/{chatId}/messages")
    public ResponseEntity<Void> sendMessageToBot(@PathVariable Long chatId,
                                                 @RequestBody RequestMessageDto requestMessageDto) {
        sendBotMessageService.sendMessage(chatId, requestMessageDto.getText());

        return ResponseEntity.ok().build();
    }

}
