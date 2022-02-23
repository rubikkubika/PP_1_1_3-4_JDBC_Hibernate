package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
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
        UserDaoHibernateImpl userDaoHibernateImpl = new UserDaoHibernateImpl();
        userDaoHibernateImpl.createUsersTable();
    }

    public void dropUsersTable() {
        UserDaoHibernateImpl userDaoHibernateImpl = new UserDaoHibernateImpl();
        userDaoHibernateImpl.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        UserDaoHibernateImpl userDaoHibernateImpl = new UserDaoHibernateImpl();
        userDaoHibernateImpl.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
    }

    public List<User> getAllUsers() {
        UserDaoHibernateImpl userDaoHibernateImpl = new UserDaoHibernateImpl();
        return userDaoHibernateImpl.getAllUsers();
    }

    public void cleanUsersTable() {
        UserDaoHibernateImpl userDaoHibernateImpl = new UserDaoHibernateImpl();
        userDaoHibernateImpl.cleanUsersTable();
    }
}
