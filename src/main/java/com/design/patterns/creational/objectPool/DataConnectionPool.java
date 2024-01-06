package com.design.patterns.creational.objectPool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Poolable interface
interface Poolable {
    void reset();
}

// DatabaseConnection class implementing Poolable
class DatabaseConnection implements Poolable {
    private Connection connection;

    public DatabaseConnection(String url, String user, String password) throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
    }

    // Assume methods for database operations are here

    @Override
    public void reset() {
        // Reset the connection state to its initial state
        // This could involve closing and reopening the connection in a real-world scenario
        System.out.println("Database connection reset.");
    }
}

// Object Pool for DatabaseConnection
class DatabaseConnectionPool {
    private BlockingQueue<DatabaseConnection> connectionPool;

    public DatabaseConnectionPool(String url, String user, String password, int poolSize) {
        connectionPool = new ArrayBlockingQueue<>(poolSize);

        try {
            for (int i = 0; i < poolSize; i++) {
                DatabaseConnection connection = new DatabaseConnection(url, user, password);
                connectionPool.offer(connection);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public DatabaseConnection acquireConnection() throws InterruptedException {
        return connectionPool.take();
    }

    public void releaseConnection(DatabaseConnection connection) {
        connection.reset();
        connectionPool.offer(connection);
    }
}

// Example of using the DatabaseConnectionPool
class DatabaseConnectionPoolExample {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/mydatabase";
        String dbUser = "username";
        String dbPassword = "password";
        int poolSize = 5;

        DatabaseConnectionPool connectionPool = new DatabaseConnectionPool(dbUrl, dbUser, dbPassword, poolSize);

        try {
            // Acquire a connection from the pool
            DatabaseConnection connection1 = connectionPool.acquireConnection();

            // Use the connection for database operations
            System.out.println("Performing database operations with connection 1...");

            // Release the connection back to the pool
            connectionPool.releaseConnection(connection1);

            // Acquire another connection
            DatabaseConnection connection2 = connectionPool.acquireConnection();

            // Use the second connection
            System.out.println("Performing database operations with connection 2...");

            // Release the second connection back to the pool
            connectionPool.releaseConnection(connection2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
