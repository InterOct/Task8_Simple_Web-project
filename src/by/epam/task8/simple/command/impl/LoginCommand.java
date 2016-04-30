package by.epam.task8.simple.command.impl;

import by.epam.task8.simple.command.Command;
import by.epam.task8.simple.command.exception.CommandException;
import by.epam.task8.simple.controller.PageName;
import by.epam.task8.simple.entity.User;
import by.epam.task8.simple.service.UserService;
import by.epam.task8.simple.service.exception.ServiceException;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";
    private static final String USER = "user";

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        String page;

        try {
            User user = UserService.checkLogin(request.getParameter(LOGIN), request.getParameter(PASSWORD));
            if (user != null) {
                request.getSession(true).setAttribute(USER, user);
                page = PageName.USER_PAGE;
            } else {
                page = PageName.USER_NOT_FOUND;
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }

        return page;
    }

}
