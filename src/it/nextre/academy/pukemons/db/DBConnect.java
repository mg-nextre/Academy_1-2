package it.nextre.academy.pukemons.db;

import it.nextre.academy.pukemons.logger.Logger;

import java.sql.*;
import java.util.Properties;

/*package-private*/
class DBConnect {

    private static final String url = "jdbc:mysql://localhost:3306";
    private static final String nameDB = "db_pukemon";
    private static final Properties properties = new Properties();

    private static final Logger logger = Logger.getInstance();

    static {
        properties.setProperty("user","root");
        properties.setProperty("password","root");
        properties.setProperty("useTimezone","true");
        properties.setProperty("serverTimezone","GMT+1");
    }

    /*package-private*/
    static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url+"/"+nameDB,properties);
        return connection;
    }

    /*package-private*/
    static void createDB() throws SQLException {
        Connection connection = DriverManager.getConnection(url,properties);
        PreparedStatement statement = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS "+nameDB);
        if(statement.execute()){
            logger.write("DB CREATED");
        }else{
            logger.write("DB ALREADY EXISTENT");
        }
        connection.close();
    }

    static void dropDB() throws SQLException {
        Connection connection = DriverManager.getConnection(url,properties);
        PreparedStatement statement = connection.prepareStatement("DROP DATABASE "+nameDB);
        if(statement.execute()){
            logger.write("DB DROPPED");
        }else{
            logger.write("DB CANNOT BE DROPPED");
        }
        connection.close();
    }

}//end class
