package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        userList.add(new User("Artem", "Retsko", (byte) 33));
        userList.add(new User("Ivan", "Ivanov", (byte) 34));
        userList.add(new User("Petya", "Petrov", (byte) 35));
        userList.add(new User("Vasya", "Vasechkin", (byte) 36));
        UserServiceImpl service = new UserServiceImpl();

        service.createUsersTable();
        userList.forEach(service);
        service.getAllUsers();
        service.cleanUsersTable();
        service.dropUsersTable();

    }
}