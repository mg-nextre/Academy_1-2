package it.nextre.academy.esercizi.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class ConnectionToDB {

    public static void main(String[] args) throws FileNotFoundException {

        //OptionalLong ol = OptionalLong.of(0);
        //Optional<Long> oll = Optional.of(0L);

        //FileInputStream fis = new FileInputStream("src/it/nextre/academy/esercizi/db/nextre_qualcosa.txt");

        final String urlConnection = "jdbc:mysql://localhost:3306/standford_university";
        final String root = "root";
        final String pass = "root";

        //final String timeZone = "&useTimezone=true&serverTimezone=GMT%2B1";

        //final String stringConnection = urlConnection+"?user="+root+"&password="+pass+timeZone;
        //final String connection = "jdbc:mysql://localhost:3306/standford_university?user=root&password=root&useTimezone=true&serverTimezone=GMT%2B1";

        Properties p = new Properties();
        //p.setProperty("url",urlConnection);
        p.setProperty("user",root);
        p.setProperty("password",pass);
        p.setProperty("useTimezone","true");
        p.setProperty("serverTimezone","GMT+1");
        //p.setProperty("","");

        Timestamp timestampNow = Timestamp.valueOf(LocalDateTime.now());

        try(Connection dbConnection = DriverManager.getConnection(urlConnection,p)){

            Statement statement = dbConnection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM cinema;");

            while(resultSet.next()){
                System.out.println(resultSet.getString("nome"));
            }

        }catch(SQLException sqle){
            sqle.printStackTrace();
        }

    }//end main
}//end class
