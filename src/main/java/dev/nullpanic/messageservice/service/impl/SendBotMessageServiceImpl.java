package dev.nullpanic.messageservice.service.impl;

import dev.nullpanic.messageservice.bot.CarSalesTelegramBot;
import dev.nullpanic.messageservice.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


@Service
public class SendBotMessageServiceImpl implements SendBotMessageService {

    private CarSalesTelegramBot bot;

    @Lazy
    @Autowired
    public void setBot(CarSalesTelegramBot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(Long chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException exception) {
            exception.printStackTrace();
        }
    }
}
