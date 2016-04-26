package by.epam.task8.simple.command;

import by.epam.task8.simple.command.exception.CommandException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
    String execute(HttpServletRequest request) throws CommandException;
}
