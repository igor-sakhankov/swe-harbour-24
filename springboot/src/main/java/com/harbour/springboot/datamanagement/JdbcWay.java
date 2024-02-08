package com.harbour.springboot.datamanagement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class JdbcWay {
    @Value("${mysql.url}")
    private String url;
    @Value("${mysql.username}")
    private String username;
    @Value("${mysql.password}")
    private String password;

    public List<Map<String, String>> fetchFromDatabase() {
        try {
            // Open a connection
            System.out.println("Connecting to a selected database...");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected database successfully...");

            // Execute a query
            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String sql = "SELECT id, name, country FROM authors"; // Assuming your table has id, name, and country columns
            ResultSet rs = stmt.executeQuery(sql);

            List<Map<String, String>> result = new ArrayList<>();
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String country = rs.getString("country");

                result.add(Map.of("id", String.valueOf(id), "name", name, "country", country));

            }
            rs.close();
            stmt.close();
            conn.close();
            return result;
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        }
        return List.of();
    }

}
