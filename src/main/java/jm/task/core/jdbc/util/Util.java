package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/new_schema";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;

    public static Statement getConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        return stmt = con.createStatement();
    }

    public static void closeConnection() throws SQLException {
        con.close();
        stmt.close();
    }
}
