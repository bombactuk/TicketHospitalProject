package edu.traning.web.controller;

import java.util.HashMap;
import java.util.Map;

import edu.traning.web.controller.impl.command.*;
import edu.traning.web.controller.impl.command.clinic.ClinicAddCommand;
import edu.traning.web.controller.impl.command.clinic.ClinicSearchCommand;
import edu.traning.web.controller.impl.command.clinic.ClinicUpdateCommand;
import edu.traning.web.controller.impl.command.information.FooterAddCommand;
import edu.traning.web.controller.impl.command.information.FooterUpdateCommand;
import edu.traning.web.controller.impl.command.information.AboutUsUpdateCommand;
import edu.traning.web.controller.impl.command.news.NewsAddCommand;
import edu.traning.web.controller.impl.command.news.NewsUpdateCommand;
import edu.traning.web.controller.impl.command.user.UserAuthorizationCommand;
import edu.traning.web.controller.impl.command.user.UserLogoutCommand;
import edu.traning.web.controller.impl.command.user.UserRegistrationCommand;
import edu.traning.web.controller.impl.command.user.UserUpdateCommand;
import edu.traning.web.controller.impl.command.doctor.DoctorAddCommand;
import edu.traning.web.controller.impl.command.doctor.DoctorSearchCommand;
import edu.traning.web.controller.impl.command.doctor.DoctorUpdateCommand;
import edu.traning.web.controller.impl.pagetransition.*;

public class CommandProvider {

    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {

        this.repository.put(CommandName.WRONG_REQUEST, new NoSuchCommand());

        this.repository.put(CommandName.GO_TO_REGISTRATION, new GoToTheRegistrationPage());
        this.repository.put(CommandName.GO_TO_AUTHORIZATION, new GoToTheAuthorization());
        this.repository.put(CommandName.GO_TO_INDEX_PAGE, new GoToIndexPade());
        this.repository.put(CommandName.GO_TO_ABOUT_US, new GoToAboutUs());
        this.repository.put(CommandName.GO_TO_CLINICS, new GoToClinics());
        this.repository.put(CommandName.GO_TO_CLINIC_INFO, new GoToClinicInfo());
        this.repository.put(CommandName.GO_TO_USER_PROFILE, new GoToProfileUser());
        this.repository.put(CommandName.GO_TO_ADMIN_PROFILE, new GoToProfileAdmin());
        this.repository.put(CommandName.GO_TO_DOCTORS, new GoToDoctors());
        this.repository.put(CommandName.GO_TO_DOCTOR_INFO, new GoToDoctorInfo());

        this.repository.put(CommandName.NEW_USER_REGISTRATION, new UserRegistrationCommand());
        this.repository.put(CommandName.DO_AUTH, new UserAuthorizationCommand());
        this.repository.put(CommandName.DO_REGISTRATION, new UserRegistrationCommand());
        this.repository.put(CommandName.LOGOUT_FROM_ACCOUNT, new UserLogoutCommand());
        this.repository.put(CommandName.UPDATE_USER, new UserUpdateCommand());

        this.repository.put(CommandName.ADD_CLINIC, new ClinicAddCommand());
        this.repository.put(CommandName.SEARCH_CLINIC, new ClinicSearchCommand());
        this.repository.put(CommandName.UPDATE_CLINIC, new ClinicUpdateCommand());

        this.repository.put(CommandName.SEARCH_DOCTOR, new DoctorSearchCommand());
        this.repository.put(CommandName.ADD_DOCTOR, new DoctorAddCommand());
        this.repository.put(CommandName.UPDATE_DOCTOR, new DoctorUpdateCommand());

        this.repository.put(CommandName.ADD_FOOTER, new FooterAddCommand());
        this.repository.put(CommandName.UPDATE_ABOUT, new AboutUsUpdateCommand());
        this.repository.put(CommandName.UPDATE_FOOTER, new FooterUpdateCommand());

        this.repository.put(CommandName.ADD_NEWS, new NewsAddCommand());
        this.repository.put(CommandName.UPDATE_NEWS, new NewsUpdateCommand());

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
