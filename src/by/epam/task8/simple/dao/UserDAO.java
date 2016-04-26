package by.epam.task8.simple.dao;

import by.epam.task8.simple.dao.exception.ConnectionPoolException;
import by.epam.task8.simple.dao.exception.DAOException;
import by.epam.task8.simple.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Aspire on 24.04.2016.
 */
public class UserDAO {
    private static final Logger LOGGER = LogManager.getRootLogger();

    public List<User> getUsers() throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        List<User> users = new LinkedList<>();
        try {
            connection = connectionPool.takeConnection();
            String sql = "SELECT login, password FROM Users";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                users.add(new User(0, rs.getString(1), rs.getString(2)));
            }

        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error closing connection",e);
            }
        }

        return users;

    }

    public User getUser(String login, String password) throws DAOException {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        User user = null;
        try {
            connection = connectionPool.takeConnection();
            String sql = "SELECT login, password FROM Users WHERE \'" + login + "\' = login AND \'" + password + "\' = password";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(0, rs.getString(1), rs.getString(2));
            }

        } catch (ConnectionPoolException | SQLException e) {
            throw new DAOException(e);
        } finally {
            try {
                if (connection!=null) {
                    connection.close();
                }
            } catch (SQLException e) {
                LOGGER.error("Error closing connection",e);
            }
        }

        return user;
    }


}
