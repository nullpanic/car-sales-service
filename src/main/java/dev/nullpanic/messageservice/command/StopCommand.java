package dev.nullpanic.messageservice.command;

import dev.nullpanic.messageservice.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StopCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String STOP_MESSAGE = "Бот остановлен.";

    @Autowired
    public StopCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();

        sendBotMessageService.sendMessage(chatId, STOP_MESSAGE);
    }
}
