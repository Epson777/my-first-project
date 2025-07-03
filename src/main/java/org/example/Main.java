package org.example;

import java.sql.*;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3307/mydbtest";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            System.out.println("Driver Registered!");
        } catch (SQLException e) {
            System.err.println("Could not connect to database");
        }

        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); Statement statement = connection.createStatement()) {
            System.out.println("Connected to database");
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Samvel', 18, 'oslik228@mail.ru')");
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Igor', 18, 'panyukov@mail.ru')");
            statement.addBatch("INSERT INTO users (name, age, email) VALUES ('Sauna', 18, 'dudinin@mail.ru')");

            statement.executeBatch();
            System.out.println("Batch Inserted!");
            statement.clearBatch();
            System.out.println("Batch Cleared!");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
