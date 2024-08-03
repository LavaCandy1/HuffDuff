package com.HuffDuff;

import java.sql.*;

public class classCoordinateFinder {
    int xCoord;
    int yCoord;

    public String classCoordinateFinder1(String name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/huffduff", "root", "Tatanano1!");

            String query = "SELECT xCoord, yCoord FROM bfirstfloor WHERE name = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                xCoord = rs.getInt("xCoord");
                yCoord = rs.getInt("yCoord");
                DemoClass obj2 = new DemoClass();
                String outPath = obj2.DemoClass1(xCoord, yCoord);
                
                return outPath;
            } else {
                System.out.println("No results found for name: " + name);
                return "Ayush";
            }

            // Close resources
            
        } catch (Exception e) {
            e.printStackTrace();
            return "Sid";
        }
    }
    
}