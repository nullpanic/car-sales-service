package dev.nullpanic.messageservice;

import dev.nullpanic.messageservice.bot.CarSalesTelegramBot;
import dev.nullpanic.messageservice.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class MessageServiceApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        CarSalesTelegramBot bot = context.getBean("carSalesTelegramBot", CarSalesTelegramBot.class);

        try {
            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException exception) {
            exception.printStackTrace();
        }
    }
}
