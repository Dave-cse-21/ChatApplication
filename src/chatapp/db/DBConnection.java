package chatapp.db;

import java.sql.*;

public class DBConnection {

    private static final String URL = "jdbc:mysql://localhost:3306/chatapp"; // your DB
    private static final String USER = "root"; // your MySQL username
    private static final String PASS = "De122924"; 

    private static Connection conn;

    // Get database connection
    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            conn = DriverManager.getConnection(URL, USER, PASS);
        }
        return conn;
    }

    // Test connection
    public static void main(String[] args) {
        try {
            Connection c = DBConnection.getConnection();
            if (c != null) {
                System.out.println("Database connection successful!");
            }
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
        }
    }
}
