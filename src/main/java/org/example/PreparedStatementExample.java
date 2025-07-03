package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class PreparedStatementExample {
    private static final String URL = "jdbc:mysql://localhost:3307/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

//    private static final String SQLRequest = "INSERT INTO users3 VALUES(?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL = "SELECT * FROM users3";

    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(GET_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String description = resultSet.getString("description");
                double rating = resultSet.getDouble("rating");
                boolean published = resultSet.getBoolean("published");
                Date created = resultSet.getDate("created");
                byte [] icon = resultSet.getBytes("icon");

                System.out.println("ID: " + id + ", title: " + title + ", rating: " + rating + ", published: " + published +
                        ", created: " + created + ", description: " + description + ", icon length = " + icon.length);
            }
//            preparedStatement = connection.prepareStatement(SQLRequest);
//            preparedStatement.setInt(1, 1);
//            preparedStatement.setString(2, "random title");
//            preparedStatement.setString(3, "random description");
//            preparedStatement.setDouble(4, 0.2);
//            preparedStatement.setBoolean(5, true);
//            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
//            preparedStatement.setBlob(7, new FileInputStream("C:\\Users\\knara\\OneDrive\\Рабочий стол\\i.webp"));
//
//            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
