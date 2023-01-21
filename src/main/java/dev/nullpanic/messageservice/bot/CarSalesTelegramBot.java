package dev.nullpanic.messageservice.bot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
public class CarSalesTelegramBot extends TelegramLongPollingBot {

    @Value("${telegramBot.username}")
    private String username;
    @Value("${telegramBot.token}")
    private String token;

    @Autowired
    public CarSalesTelegramBot() {
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            String commandIdentifier = message.split(" ")[0].toLowerCase();

            //TODO делегировать выполнение комманд в commandContainer
            System.out.println(commandIdentifier);
        }
    }
}