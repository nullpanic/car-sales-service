package dev.nullpanic.messageservice.service;

public interface SendBotMessageService {

    void sendMessage(Long chatId, String message);
}
