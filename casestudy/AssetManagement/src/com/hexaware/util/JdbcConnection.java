package com.hexaware.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/AssetManagement";
    private static final String NAME = "root";
    private static final String PASSWORD = "vaishnavi@02";
    private static Connection con = null;
    
    public void access() {
    	
    }

    static {
        try {
            con = DriverManager.getConnection(URL, NAME, PASSWORD);
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}