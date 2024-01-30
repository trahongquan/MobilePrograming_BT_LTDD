package com.example.myapplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final String DATABASE_NAME = "appmess";
    private static final String DATABASE_HOST = "localhost";
    private static final String DATABASE_PORT = "3306";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "123456";

    private static DatabaseHelper mInstance;

    private Connection mConnection;

    private DatabaseHelper() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            mConnection = DriverManager.getConnection(
                    "jdbc:mysql://" + DATABASE_HOST + ":" + DATABASE_PORT + "/" + DATABASE_NAME,
                    DATABASE_USERNAME,
                    DATABASE_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static DatabaseHelper getInstance() {
        if (mInstance == null) {
            mInstance = new DatabaseHelper();
        }
        return mInstance;
    }

    public Connection getConnection() {
        return mConnection;
    }

    public void closeConnection() {
        try {
            mConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
