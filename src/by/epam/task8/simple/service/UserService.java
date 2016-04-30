package by.epam.task8.simple.service;

import by.epam.task8.simple.dao.UserDAO;
import by.epam.task8.simple.dao.exception.DAOException;
import by.epam.task8.simple.entity.User;
import by.epam.task8.simple.service.exception.ServiceException;

import java.util.List;

public final class UserService {

    public final static User checkLogin(String login, String password) throws ServiceException {
        if (!Validator.loginValidator(login, password)) {
            return null;
        }

        UserDAO userDAO = new UserDAO();
        try {
            User user =  userDAO.getUser(login,password);
            if (user != null) {
                return user;
            }

        } catch (DAOException e) {
            throw new ServiceException("Error access database",e);
        }

        return null;
    }


    static class Validator {
        public static boolean loginValidator(String login, String password) {
            if (login.isEmpty()) {
                return false;
            }
            if (password.isEmpty()) {
                return false;
            }
            return true;
        }
    }
}
