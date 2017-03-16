/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tasneem
 */
public class DB_Connection {

    public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/";
    static final String USER = "root";
    static final String PASSWORD = "0000";
    static final String DB_SCHEMA_NAME = "hat_society";
    public Connection connection = null;
    public Statement statment = null;

    public Connection getConnection() {
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL + DB_SCHEMA_NAME, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Connection Error");
        } finally {
            if (connection != null) {
                System.out.println("Connection Success");
            } else {
                System.out.println("Connection Failed!");
            }
        }
        return connection;
    }
}
