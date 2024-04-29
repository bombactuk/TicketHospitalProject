package edu.traning.web.controller;

import java.util.HashMap;
import java.util.Map;

import edu.traning.web.controller.impl.*;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        this.repository.put(CommandName.DO_AUTH, new UserAuthorizationCommand());
        this.repository.put(CommandName.DO_REGISTRATION, new UserRegistrationCommand());
        this.repository.put(CommandName.GO_TO_REGISTRATION, new GoToTheRegistrationPage());
        this.repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
        this.repository.put(CommandName.GO_TO_AUTHORIZATION, new GoToTheAuthorization());
        this.repository.put(CommandName.GO_TO_INDEX_PAGE, new GoToIndexPade());
        this.repository.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
        this.repository.put(CommandName.NEW_USER_REGISTRATION, new UserRegistrationCommand());
    }

    Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = (Command) this.repository.get(commandName);
        } catch (NullPointerException | IllegalArgumentException var5) {
            command = (Command) this.repository.get(CommandName.WRONG_REQUEST);
        }

        return command;

    }

}
