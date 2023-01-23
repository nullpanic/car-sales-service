package dev.nullpanic.messageservice;

import dev.nullpanic.messageservice.bot.CarSalesTelegramBot;
import dev.nullpanic.messageservice.config.LiquibaseStarter;
import dev.nullpanic.messageservice.config.SpringConfig;
import liquibase.exception.LiquibaseException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.sql.SQLException;

public class MessageServiceApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        CarSalesTelegramBot bot = context.getBean("carSalesTelegramBot", CarSalesTelegramBot.class);
        LiquibaseStarter liquibaseStarter = context.getBean("liquibaseStarter", LiquibaseStarter.class);

        try {
            liquibaseStarter.startLiquibase();

            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(bot);
        } catch (TelegramApiException | SQLException | LiquibaseException exception) {
            exception.printStackTrace();
        }
    }


}
