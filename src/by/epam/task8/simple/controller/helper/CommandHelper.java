package by.epam.task8.simple.controller.helper;

import by.epam.task8.simple.command.Command;
import by.epam.task8.simple.command.CommandName;
import by.epam.task8.simple.command.impl.ChangeLocal;
import by.epam.task8.simple.command.impl.LoginCommand;
import by.epam.task8.simple.command.impl.RegisterUserCommand;
import by.epam.task8.simple.command.impl.UnknownCommand;

import java.util.HashMap;
import java.util.Map;

public final class CommandHelper {
    private Map<CommandName, Command> commands = new HashMap<>();

    public CommandHelper() {

        commands.put(CommandName.LOGIN, new LoginCommand());
        commands.put(CommandName.REGISTER_USER, new RegisterUserCommand());
        commands.put(CommandName.CHANGE_LOCAL, new ChangeLocal());

    }


    public Command getCommand(String commandName) {
        Command command = null;
        CommandName key = null;

        commandName = commandName.replace('-', '_').toUpperCase();
        key = CommandName.valueOf(commandName);

        command = commands.get(key);

        if (command == null) {
            command = new UnknownCommand();
        }

        return command;
    }

}
