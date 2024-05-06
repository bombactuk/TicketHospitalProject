package edu.traning.web.controller;

import java.util.HashMap;
import java.util.Map;

import edu.traning.web.controller.impl.command.*;
import edu.traning.web.controller.impl.pageTransition.*;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        this.repository.put(CommandName.DO_AUTH, new UserAuthorizationCommand());
        this.repository.put(CommandName.DO_REGISTRATION, new UserRegistrationCommand());
        this.repository.put(CommandName.GO_TO_REGISTRATION, new GoToTheRegistrationPage());
        this.repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());
        this.repository.put(CommandName.GO_TO_AUTHORIZATION, new GoToTheAuthorization());
        this.repository.put(CommandName.GO_TO_INDEX_PAGE, new GoToIndexPade());
        this.repository.put(CommandName.NEW_USER_REGISTRATION, new UserRegistrationCommand());
        this.repository.put(CommandName.GO_TO_ABOUT_US, new GoToAboutUs());
        this.repository.put(CommandName.GO_TO_CLINICS, new GoToClinics());
        this.repository.put(CommandName.GO_TO_CLINIC_INFO, new GoToClinicInfo());
        this.repository.put(CommandName.SEARCH_CLINIC, new ClinicSearchCommand());
        this.repository.put(CommandName.GO_TO_USER_PROFILE, new GoToProfileUser());
        this.repository.put(CommandName.GO_TO_ADMIN_PROFILE, new GoToProfileAdmin());
        this.repository.put(CommandName.FUNCTION_ADMIN_PROFILE, new ClinicFunctionCommand());

    }

    Command getCommand(String name) {

        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = this.repository.get(commandName);
        } catch (NullPointerException | IllegalArgumentException var5) {
            command = this.repository.get(CommandName.WRONG_REQUEST);
        }

        return command;

    }

}
