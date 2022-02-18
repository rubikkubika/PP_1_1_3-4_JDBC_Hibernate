package jm.task.core.jdbc.util;

import java.sql.*;

public class Util {
    private static final String url = "jdbc:mysql://localhost:3306/new_schema";
    private static final String user = "root";
    private static final String password = "root";

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public static void getConnection() throws SQLException {
        con = DriverManager.getConnection(url, user, password);
        stmt = con.createStatement();
    }

    public static ResultSet getQuery(String query) throws SQLException {
        Util.getConnection();
        stmt.execute(query);
        rs = stmt.getResultSet();

        return rs;
    }

    public static void closeConnection() throws SQLException {
        con.close();
        stmt.close();
    }
}
