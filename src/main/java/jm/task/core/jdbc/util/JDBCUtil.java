package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/mvc_schema";
    private static final String USER = "root";
    private static final String PASSWORD = "a%iDT&u76nf";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        } catch (SQLException e) {
            System.out.println("Connection failed" + e.getMessage());
            e.printStackTrace();
        }
        return connection;
    }
}
