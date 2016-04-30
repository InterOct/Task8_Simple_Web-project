package by.epam.task8.simple.controller;

import by.epam.task8.simple.command.Command;
import by.epam.task8.simple.command.exception.CommandException;
import by.epam.task8.simple.controller.helper.CommandHelper;
import by.epam.task8.simple.dao.ConnectionPool;
import by.epam.task8.simple.dao.exception.ConnectionPoolException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;


public class Controller extends HttpServlet {

    private static final Logger LOGGER = LogManager.getRootLogger();
    @Override
    public void init() throws ServletException {
        try {
            ConnectionPool.getInstance().initPoolData();
        } catch (Exception e) {
            LOGGER.error("Error initializing connection pool",e);
            throw new RuntimeException(e);
        }
        
        super.init();
    }

    private static final long serialVersionUID = 1L;

    private static final String COMMAND_NAME = "command";

    private final CommandHelper commandHelper = new CommandHelper();

    public Controller() {
        super();
    }

    @Override
    protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {

        super.service(arg0, arg1);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String commandName = null;
        Command command = null;
        String page = null;
        try {
            commandName = request.getParameter(COMMAND_NAME);
            command = commandHelper.getCommand(commandName);
            page = command.execute(request);
        } catch (Throwable e) {
            LOGGER.error(e);
            page = PageName.ERROR_PAGE;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        if (dispatcher != null) {
            dispatcher.forward(request, response);
        } else {
            LOGGER.error("Impossible to go to page");
            throw new RuntimeException("Impossible to go to page");
        }

    }

}
