package dev.nullpanic.messageservice.command;

import dev.nullpanic.messageservice.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class UnknownCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String UNKNOWN_MESSAGE = "Неизвестная комманда, напишите /help для списка доступных комманд";

    @Autowired
    public UnknownCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), UNKNOWN_MESSAGE);
    }
}
