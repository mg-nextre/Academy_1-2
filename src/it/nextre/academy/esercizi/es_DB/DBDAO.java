package it.nextre.academy.esercizi.es_DB;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

public class DBDAO {

    private Connection connection;

    public DBDAO() throws SQLException {
        //DBConnect.dropDB();
        DBConnect.createDB();
        this.connection = DBConnect.getConnection();
        this.createTabellaAzienda();
        this.createTabellaDipendente();
    }

    public void createTabellaAzienda() throws SQLException {
        this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS Azienda ("+
                "id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT, "+
                "nome VARCHAR(256) NOT NULL UNIQUE, "+
                "fatturato DOUBLE(255,2), " +
                "in_attivita CHAR(1) NOT NULL DEFAULT 'T'" +
                ")"
        )
        .execute();
    }

    public void createTabellaDipendente() throws SQLException {
        this.connection.prepareStatement("CREATE TABLE IF NOT EXISTS Dipendente ("+
                "id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT, "+
                "nome VARCHAR(256) NOT NULL, "+
                "eta INT(11) UNSIGNED NOT NULL, "+
                "sesso VARCHAR(10) NOT NULL, "+
                "iban VARCHAR(256) NOT NULL, "+
                "ruolo VARCHAR(256), "+
                "email VARCHAR(256), "+
                "data_assunzione DATE NOT NULL, "+
                "azienda VARCHAR(256), " +
                //"INDEX FK_Dipendente_Azienda (azienda), " +
                "INDEX Dipendente_Key (nome,eta,sesso,iban), " +
                //"CONSTRAINT FK_Dipendente_Azienda " +
                "FOREIGN KEY (azienda) " +
                "REFERENCES Azienda (nome) " +
                "ON DELETE SET NULL" +
                ")"
        )
                .execute();
    }

    public void saveDipendente(Dipendente dipendente) throws SQLException {
        this.connection.prepareStatement("INSERT INTO Dipendente(nome,eta,sesso,iban,ruolo,email,data_assunzione, azienda) VALUES(\""+
                dipendente.getNome() + "\", " +
                dipendente.getEta() + ", \"" +
                dipendente.getSesso() + "\", \"" +
                dipendente.getIban() + "\", \"" +
                dipendente.getRuolo() + "\", \"" +
                dipendente.getEmail() + "\", \"" +
                dipendente.getDataAssunzione() + "\", \"" +
                dipendente.getAzienda().getName() + "\"" +
                ")" +
                " ON DUPLICATE KEY UPDATE nome = \""+
                dipendente.getNome() +"\",eta = "+
                dipendente.getEta() +",sesso = \""+
                dipendente.getSesso() +"\",iban = \""+
                dipendente.getIban() +"\",ruolo = \""+
                dipendente.getRuolo() +"\",email = \""+
                dipendente.getEmail() +"\",data_assunzione = \""+
                dipendente.getDataAssunzione() + "\", azienda = \""+
                dipendente.getAzienda().getName() +"\""
        )
                .execute();
    }

    public void saveAzienda(Azienda azienda) throws SQLException {
        this.connection.prepareStatement("INSERT INTO Azienda(nome, fatturato, in_attivita) VALUES(\"" +
                azienda.getName() + "\", " +
                azienda.getFatturato() + ", \"" +
                azienda.getInAttivitaForDB() + "\"" +
                ") ON DUPLICATE KEY UPDATE nome = \""+azienda.getName()+"\", fatturato = "+azienda.getFatturato() + ", in_attivita = \""+azienda.getInAttivitaForDB() + "\""
        )
                .execute();
    }

    public void deleteDipendente(Dipendente dipendente) throws SQLException {
        this.connection.prepareStatement("DELETE FROM Dipendente WHERE (" +
                "nome = \"" + dipendente.getNome() + "\" AND " +
                "eta = " + dipendente.getEta() + " AND " +
                "sesso = \"" + dipendente.getSesso() + "\" AND " +
                "iban = \"" + dipendente.getIban() +"\" AND " +
                "email = \"" + dipendente.getEmail() +"\" AND " +
                "data_assunzione = \"" + dipendente.getDataAssunzione().format(DateTimeFormatter.ISO_DATE) +"\" AND " +
                "azienda = \"" + dipendente.getAzienda().getName() + "\" " +
                ")"
        )
                .execute();
    }

    /*public void deleteAzienda(Azienda azienda) throws SQLException {
        this.connection.prepareStatement("DELETE FROM Azienda WHERE (" +
                "nome = \"" + azienda.getName() + "\"" +
                ")"
        )
                .execute();
    }*/

    /*public void deleteTableDipendente() throws SQLException {
        this.connection.prepareStatement("DELETE FROM Dipendente")
                .execute();
    }

    public void deleteTableAzienda() throws SQLException {
        this.connection.prepareStatement("DELETE FROM Azienda")
                .execute();
    }*/

    public void closeConnection() throws SQLException {
        this.connection.close();
    }

}//end class
