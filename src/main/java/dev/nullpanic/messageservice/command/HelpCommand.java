package dev.nullpanic.messageservice.command;

import dev.nullpanic.messageservice.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.Update;

import static dev.nullpanic.messageservice.command.CommandName.*;

@Component
public class HelpCommand implements Command {

    private final SendBotMessageService sendBotMessageService;

    public final static String HELP_MESSAGE = String.format("""
                    <b>Доступные команды</b>
                                
                    <b>Общие</b>
                    %s - запустить бота
                    %s - остановить бота""",
            START.getCommandName(),
            STOP.getCommandName());

    @Autowired
    public HelpCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId(), HELP_MESSAGE);
    }
}
