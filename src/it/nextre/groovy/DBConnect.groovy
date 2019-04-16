package it.nextre.groovy

import it.nextre.academy.pukemons.logger.Logger

import java.sql.Connection
import java.sql.DriverManager
import java.sql.PreparedStatement
import java.sql.SQLException

class DBConnect {

    static final String url = "jdbc:mysql://localhost:3306"
    static final String nameDB = "db_ecommerce"
    static final Properties properties = new Properties()

    static {
        properties.setProperty("user","root")
        properties.setProperty("password","root")
        properties.setProperty("useTimezone","true")
        properties.setProperty("serverTimezone","GMT+1")
    }

    /*package-private*/
    static Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(url+"/"+nameDB,properties)
        return connection
    }

    /*package-private*/
    static void createDB() throws SQLException {
        Connection connection = DriverManager.getConnection(url,properties)
        PreparedStatement statement = connection.prepareStatement("CREATE DATABASE IF NOT EXISTS "+nameDB)
        statement.execute()
        connection.close()
    }

    static void dropDB() throws SQLException {
        Connection connection = DriverManager.getConnection(url,properties)
        PreparedStatement statement = connection.prepareStatement("DROP DATABASE "+nameDB)
        statement.execute()
        connection.close()
    }

}//end groovy class
