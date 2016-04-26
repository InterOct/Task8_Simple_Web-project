package by.epam.task8.simple.command.impl;

import by.epam.task8.simple.command.Command;
import by.epam.task8.simple.command.exception.CommandException;
import by.epam.task8.simple.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UnknownCommand implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        // TODO Auto-generated method stub

        HttpSession ses = request.getSession(false);

        if (ses != null) {
            User usrer = (User) ses.getAttribute("login");

        } else {

        }


        return null;
    }

}
