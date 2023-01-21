package dev.nullpanic.messageservice.command;

import dev.nullpanic.messageservice.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String START_MESSAGE = "Добро пожаловать в Car Sales! У нас вы можете заказать себе новый автомобиль." +
            " Введите /help для того, чтобы узнать список комманд";

    @Autowired
    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }
}
