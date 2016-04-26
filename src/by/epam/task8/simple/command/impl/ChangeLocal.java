package by.epam.task8.simple.command.impl;

import by.epam.task8.simple.command.Command;
import by.epam.task8.simple.command.exception.CommandException;
import by.epam.task8.simple.controller.PageName;

import javax.servlet.http.HttpServletRequest;

public class ChangeLocal implements Command {

    @Override
    public String execute(HttpServletRequest request) throws CommandException {
        request.getSession(true).setAttribute("local", request.getParameter("local"));
        return PageName.INDEX_PAGE;
    }


}
