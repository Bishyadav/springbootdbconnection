package com.example.springbootdbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@org.springframework.stereotype.Repository
public class Repository {

    public String getConnectStatus() throws SQLException {


        String url = "jdbc:postgresql://localhost:5432/EmployeesDetails";  // Update with your database URL
        String user = "postgres";  // Replace with your username
        String password = "root";  // Replace with your password

        // Test connection
        Connection connection = DriverManager.getConnection(url, user, password);
            if (connection != null) {
                System.out.println("Successfully connected to the database!");
                return "success";
            } else {
                System.out.println("Failed to connect to the database.");
                return "failed to connect";
            }
    }
}

