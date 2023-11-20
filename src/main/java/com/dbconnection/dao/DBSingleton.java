package com.dbconnection.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBSingleton {
    private static DBSingleton instance;
    private Connection connection;

    private DBSingleton() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static DBSingleton getInstance() {
        if (instance == null) {
            instance = new DBSingleton();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

}
