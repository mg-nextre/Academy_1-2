package it.nextre.academy.esercizi.es_DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnect {

    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String nameDB = "es_db";
    private static final Properties properties = new Properties();

    static {
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        properties.setProperty("useTimezone","true");
        properties.setProperty("serverTimezone","GMT+1");
    }

    /*package-private*/
    static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url+"/"+nameDB,properties);
        System.out.println("getting connection");
        return connection;
    }

    /*package-private*/
    static void createDB() throws SQLException {
        Connection connection = DriverManager.getConnection(url,properties);
        PreparedStatement statement = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS "+nameDB);
        statement.execute();
        System.out.println("created DB");
        connection.close();
    }

    static void dropDB() throws SQLException {
        Connection connection = DriverManager.getConnection(url,properties);
        PreparedStatement statement = connection.prepareStatement("DROP DATABASE "+nameDB);
        statement.execute();
        System.out.println("dropped DB");
        connection.close();
    }

    static void qualcosa(){
        System.out.println("qualcosa");
    }

}//end class
