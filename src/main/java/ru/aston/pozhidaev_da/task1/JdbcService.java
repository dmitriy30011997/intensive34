package ru.aston.pozhidaev_da.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class JdbcService {
    private static JdbcService instance;
    private Connection connection;

    // Чтение настроек подключения из application.properties
    private ResourceBundle resourceBundle = ResourceBundle.getBundle("application");

    private JdbcService() {
        // Приватный конструктор для Singleton
        initializeConnection();
    }

    public static JdbcService getInstance() {
        if (instance == null) {
            synchronized (JdbcService.class) {
                if (instance == null) {
                    instance = new JdbcService();
                }
            }
        }
        return instance;
    }

    private void initializeConnection() {
        try {
            // Загрузка драйвера JDBC
            Class.forName(resourceBundle.getString("jdbc.driver"));

            // Создание подключения к базе данных
            connection = DriverManager.getConnection(
                    resourceBundle.getString("jdbc.url"),
                    resourceBundle.getString("jdbc.username"),
                    resourceBundle.getString("jdbc.password")
            );
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to the database.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
