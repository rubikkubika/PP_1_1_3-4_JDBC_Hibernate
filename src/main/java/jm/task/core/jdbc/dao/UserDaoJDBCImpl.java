package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class UserDaoJDBCImpl implements UserDao, Consumer<User> {
    public UserDaoJDBCImpl() {

    }

    private List<User> userList = new ArrayList<>();

    public void createUsersTable() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS users(ID int NOT NULL AUTO_INCREMENT,PRIMARY KEY (ID), name varchar(255), lastname varchar(255), age tinyint);";
            Util.getQuery(query);
            Util.closeConnection();
        } catch (SQLException e) {

        }
    }

    public void dropUsersTable() {
        try {
            String query = "DROP TABLE IF  EXISTS  users;";
            Util.getQuery(query);
            Util.closeConnection();
        } catch (SQLException e) {

        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try {
            String query = "INSERT Users(name, lastname, age) VALUES ('" + name + "', '" + lastName + "', '" + age + "');";
            Util.getQuery(query);
            Util.closeConnection();
        } catch (SQLException e) {

        }

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        try {
            String query = "select * from users;";
            ResultSet rs = Util.getQuery(query);
            int count = 0;
            while (rs.next()) {
                userList.add(new User(rs.getString(2), rs.getString(3), rs.getByte(4)));
                userList.get(count).setId(rs.getLong(1));
                count++;
            }
            userList.forEach(x -> System.out.println(x.toString()));
            Util.closeConnection();

        } catch (SQLException e) {

        }
        return userList;
    }

    public void cleanUsersTable() {
        try {
            String query = "TRUNCATE TABLE users;";
            Util.getQuery(query);
            Util.closeConnection();
        } catch (SQLException e) {

        }
    }

    @Override
    public void accept(User user) {

        saveUser(user.getName(), user.getLastName(), user.getAge());
        System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
    }
}
