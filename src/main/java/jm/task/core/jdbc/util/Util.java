package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/new_schema";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;

    public static Connection getConnection() throws SQLException {

        return con = DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection() throws SQLException {
        con.close();
    }
}
