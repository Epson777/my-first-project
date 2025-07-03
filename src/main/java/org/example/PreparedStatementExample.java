package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Calendar;

public class PreparedStatementExample {
    private static final String URL = "jdbc:mysql://localhost:3307/mydbtest";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static final String SQLRequest = "INSERT INTO users3 VALUES(?, ?, ?, ?, ?, ?, ?)";


    public static void main(String[] args) {
        Connection connection;
        PreparedStatement preparedStatement;

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            preparedStatement = connection.prepareStatement(SQLRequest);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, "random title");
            preparedStatement.setString(3, "random description");
            preparedStatement.setDouble(4, 0.2);
            preparedStatement.setBoolean(5, true);
            preparedStatement.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
            preparedStatement.setBlob(7, new FileInputStream("C:\\Users\\knara\\OneDrive\\Рабочий стол\\i.webp"));

            preparedStatement.execute();

        } catch (SQLException | FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
