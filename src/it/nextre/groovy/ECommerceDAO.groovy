package it.nextre.groovy

import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException

class ECommerceDAO {

    static Connection connection = null
    static{
        try {
            DBConnect.dropDB()
            DBConnect.createDB()
            connection = DBConnect.getConnection()
            createTabellaUtente()
            createTabellaCarrello()
            createTabellaProdotto()
            createTabellaCarrelloProdotto()

        }catch(SQLException sqle){
            sqle.printStackTrace()
        }
    }

    private static void createTabellaUtente(){
        String sql = "CREATE TABLE Utente ("+
                "username VARCHAR(255) NOT NULL PRIMARY KEY,"+
                "saldo DECIMAL(65,2) NOT NULL) "
        connection.prepareStatement(sql).execute()
    }

    private static void createTabellaCarrello(){
        String fk = "FK_Carrello_Utente"
        String sql = "CREATE TABLE Carrello ("+
                "id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT,"+
                "nome VARCHAR(255) NOT NULL, "+
                "username_utente VARCHAR(255) NOT NULL,"+
                " UNIQUE(nome,username_utente), "+
                "INDEX "+fk+" (username_utente),"+
                //" CONSTRAINT "+fk+
                " FOREIGN KEY(username_utente) "+
                "REFERENCES Utente (username) "+
                "ON DELETE CASCADE" +
                ")"
        connection.prepareStatement(sql).execute()
    }

    private static void createTabellaProdotto(){
        String sql = "CREATE TABLE Prodotto ("+
                "id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "nome VARCHAR(255) NOT NULL UNIQUE," +
                "prezzo DECIMAL(65,2) NOT NULL," +
                "tipologia VARCHAR(255) NOT NULL," +
                "cashback INT(3) NOT NULL DEFAULT (0)," +
                "sconto INT(3) NOT NULL DEFAULT (0)" +
                ")"
        connection.prepareStatement(sql).execute()
    }

    private static void createTabellaCarrelloProdotto(){
        String fk1 = "FK_Carrello_Prodotto_Carrello"
        String fk2 = "FK_Carrello_Prodotto_Prodotto"
        String sql = "CREATE TABLE Carrello_Prodotto (" +
                "id INT(11) NOT NULL PRIMARY KEY AUTO_INCREMENT," +
                "idC INT(11) NOT NULL, " +
                "idP INT(11) NOT NULL, " +
                "INDEX "+fk1+" (idC), " +
                "INDEX "+fk2+" (idP), " +
                //"CONSTRAINT "+fk1+
                " FOREIGN KEY(idC) " +
                "REFERENCES Carrello (id)"+
                " ON DELETE CASCADE, "+
                //"CONSTRAINT "+fk2+
                " FOREIGN KEY(idP) " +
                "REFERENCES Prodotto (id) "+
                "ON DELETE CASCADE" +
                ")"
        connection.prepareStatement(sql).execute()
    }

    //update
    static void updateTabellaUtente(String username, BigDecimal saldo){
        String sql = "UPDATE Utente SET " +
                "username = $username, saldo = $saldo"
        connection.prepareStatement(sql).execute()
    }
    static void updateTabellaCarrello(String username){
        String sql = "UPDATE Carrello SET " +
                "username_utente = $username"
        connection.prepareStatement(sql).execute()
    }
    static void updateTabellaProdotto(String nome, BigDecimal prezzo, Prodotto.Tipologia tipologia, BigInteger cashback, BigInteger sconto){
        String sql = "UPDATE Prodotto SET " +
                "nome = $nome, prezzo = $prezzo, tipologia = $tipologia, cashback = $cashback, sconto = $sconto"
        connection.prepareStatement(sql).execute()
    }

    //select
    private static Map<String, Integer> select(String username, String nomeProdotto, String nomeCarrello){
        String sql = "SELECT C.id, P.id from Utente" +
                " JOIN Carrello as C ON Utente.username = C.username_utente" +
                " JOIN Prodotto as P" +
                " WHERE Utente.username = \"$username\" AND P.nome = \"$nomeProdotto\" AND C.nome = \"$nomeCarrello\""
        ResultSet resultSet = connection.prepareStatement(sql).executeQuery()
        Map<String, Integer> map = new HashMap<>()

        while(resultSet.next()){
            Integer idC = resultSet.getInt(1)
            Integer idP = resultSet.getInt(2)
            map.put("idC",idC)
            map.put("idP",idP)
        }

        return map
    }

    //insert
    static void insertTabellaCarrelloProdotto(String username, String nomeProdotto, String nomeCarrello){

        Map<String, Integer> map = select(username, nomeProdotto, nomeCarrello)
        String sql = "INSERT INTO Carrello_Prodotto (idC, idP) VALUES (" +
                map.get("idC").intValue() + ", "+
                map.get("idP").intValue() +
                ")"
        connection.prepareStatement(sql).execute()
    }
    static void insertTabellaUtente(Utente utente){
        String sql = "INSERT INTO Utente (username, saldo) VALUES(\"" +
                utente.username + "\", "+
                utente.saldo + ")"
        connection.prepareStatement(sql).execute()
    }
    static void insertTabellaProdotto(Prodotto prodotto){
        String sql = "INSERT INTO Prodotto (nome,prezzo,tipologia,cashback,sconto) VALUES(\"" +
                prodotto.nome + "\", "+
                prodotto.prezzo + ", \""+
                prodotto.tipologia + "\", "+
                prodotto.cashback + ", "+
                prodotto.sconto + ")"
        connection.prepareStatement(sql).execute()
    }
    static void insertTabellaCarrello(String nomeCarrello, Utente utente){
        String sql = "INSERT INTO Carrello (nome,username_utente) VALUES(\"" +
                nomeCarrello + "\", \""+
                utente.username + "\")"
        connection.prepareStatement(sql).execute()
    }

}//end groovy class
