package dev.nullpanic.messageservice.command;

import dev.nullpanic.messageservice.persist.model.TelegramUser;
import dev.nullpanic.messageservice.service.SendBotMessageService;
import dev.nullpanic.messageservice.service.TelegramUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

@Component
@RequiredArgsConstructor
public class StartCommand implements Command {

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public final static String START_MESSAGE = "Добро пожаловать в Car Sales! У нас вы можете заказать себе новый автомобиль." +
            " Введите /help для того, чтобы узнать список комманд";

    @Override
    public void execute(Update update) {
        Long chatId = update.getMessage().getChatId();

        TelegramUser telegramUser = telegramUserService.findUser(chatId)
                .orElse(registerNewTelegramUser(update));
        telegramUser.setActive(true);

        telegramUserService.saveUser(telegramUser);

        sendBotMessageService.sendMessage(chatId, START_MESSAGE);
    }

    private TelegramUser registerNewTelegramUser(Update update) {
        TelegramUser telegramUser = TelegramUser.builder()
                .chatId(update.getMessage().getChatId())
                .username(update.getMessage().getFrom().getUserName())
                .firstName(update.getMessage().getFrom().getFirstName())
                .lastName(update.getMessage().getFrom().getLastName())
                .build();

        return telegramUserService.saveUser(telegramUser);
    }
}
