package dev.nullpanic.messageservice.command;

import com.google.common.collect.ImmutableMap;
import dev.nullpanic.messageservice.service.SendBotMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;

    private final Command unknownCommand;

    @Autowired
    public CommandContainer(SendBotMessageService sendBotMessageService,
                            StartCommand startCommand,
                            StopCommand stopCommand,
                            HelpCommand helpCommand) {
        commandMap = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getCommandName(), startCommand)
                .put(CommandName.STOP.getCommandName(), stopCommand)
                .put(CommandName.HELP.getCommandName(), helpCommand)
                .build();

        unknownCommand = new UnknownCommand(sendBotMessageService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }
}
