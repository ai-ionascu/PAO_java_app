package ro.unibuc.auction.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.lang.System;


public class dbCon {

    private static dbCon instance;
    private Connection connection;
    private String url = System.getenv("DB_URL");
    private String username = System.getenv("DB_USER");
    private String password = System.getenv("DB_PASS");
    private dbCon() {
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection successful.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static synchronized dbCon getInstance() {
        if (instance == null) {
            instance = new dbCon();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
            System.out.println("Connection closed.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
