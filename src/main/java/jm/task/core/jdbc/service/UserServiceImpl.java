package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UserServiceImpl implements UserService {
    public void createUsersTable() {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
    }

    public List<User> getAllUsers() {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        return userDaoJDBC.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoJDBCImpl userDaoJDBC = new UserDaoJDBCImpl();
        userDaoJDBC.cleanUsersTable();

    }
}
