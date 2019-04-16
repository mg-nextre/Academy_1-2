package it.nextre.academy.pukemons.db;

import it.nextre.academy.pukemons.effects.Effect;
import it.nextre.academy.pukemons.logger.Logger;
import it.nextre.academy.pukemons.moves.*;
import it.nextre.academy.pukemons.pukemons.Pukachu;
import it.nextre.academy.pukemons.pukemons.Pukemon;
import it.nextre.academy.pukemons.pukemons.Snurlax;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PukemonDAO {

    private static final Logger logger = Logger.getInstance();

    private static final Column[] COLUMNS_PUKEMON = new Column[]{
            new Column<String>("name", "", 256, false, false, false, true, false, false),
            new Column<Integer>("hitpoints", 0, 11, false, false, false, false, false, false),
            new Column<Integer>("armor", 0, 11, false, false, false, false, false, false),
            new Column<Integer>("attack", 0, 11, false, false, false, false, false, false),
            //new Column<Integer>("moves",0,10,false,false,false,false,false,false)
    };

    private static final Column[] COLUMNS_MOVES = new Column[]{
            new Column<String>("name", "", 256, false, false, false, true, false, false),
            new Column<Integer>("damage", 0, 11, false, false, false, false, false, false),
            new Column<Integer>("accuracy", 0, 11, false, false, false, false, false, false),
            new Column<Integer>("velocity", 0, 11, false, false, false, false, false, false),
            /*new Column<String>("effect", "", 10,false,false,false,false,false,false),*/
            new Column<Integer>("probabilityToSufferEffect", 0, 11, false, false, false, false, false, false),
            new Column<String>("effect", "", 256, false, false, false, false, false, true)
    };

    private static final Column[] COLUMNS_PUKEMON_MOVES = new Column[]{
            new Column<String>("pname", "", 256, false, false, false, false, false, true),
            new Column<String>("mname", "", 256, false, false, false, false, false, true)
    };

    private static final Column[] COLUMNS_EFFECTS = new Column[]{
            new Column<String>("type","",256,false,false,false,true,false,false)
    };

    static {
        try {
            /**/
            DBConnect.dropDB();
            /**/
            DBConnect.createDB();
            try (Connection connToPukemonDB = DBConnect.getConnection()) {
                /*DB CREATION*/
                System.out.println("TRYING TO CONNECT TO DB...");
                DBConnect.createDB();
                System.out.println("DB CONNECTED");

                /*TABLES CREATION*/
                connToPukemonDB.prepareStatement(createTable("Pukemon", COLUMNS_PUKEMON)).execute();
                connToPukemonDB.prepareStatement(createTable("Moves", COLUMNS_MOVES)).execute();
                connToPukemonDB.prepareStatement(createTable("Pukemon_Moves", COLUMNS_PUKEMON_MOVES)).execute();
                connToPukemonDB.prepareStatement(createTable("Effects", COLUMNS_EFFECTS)).execute();

                /*ALTER TABLES*/
                connToPukemonDB.prepareStatement(alterTableForeignKey("Pukemon_Moves", "Pukemon", "pname","name")).execute();
                connToPukemonDB.prepareStatement(alterTableForeignKey("Pukemon_Moves", "Moves", "mname","name")).execute();
                connToPukemonDB.prepareStatement(alterTableForeignKey("Moves", "Effects", "effect","type")).execute();

                /*ROW INSERT*/
                List<Pukemon> pokemonList = new ArrayList<>(Arrays.asList(new Pukachu(), new Snurlax()));
                pokemonList.stream().forEach(p -> {
                    try {
                        connToPukemonDB.prepareStatement(upsertTable("Pukemon", new Column[]{
                                new Column<String>("name", p.getName()),
                                new Column<Integer>("hitpoints", p.getHitPoints()),
                                new Column<Integer>("armor", p.getArmor()),
                                new Column<Integer>("attack", p.getAttack()),
                                //new Column<String>("moves", Arrays.toString(p.getMoves()))
                        })).execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

                /*ROW INSERT*/
                List<Effect> effectList = new ArrayList<>(Arrays.asList(Effect.NONE,Effect.PARALYZE,Effect.POISON,Effect.BURN));
                effectList.stream().forEach(e -> {
                    try {
                        connToPukemonDB.prepareStatement(upsertTable("Effects", new Column[]{
                                new Column<String>("type", e.toString())
                        })).execute();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                });

                /*ROW INSERT*/
                List<Move> moveList = new ArrayList<>(Arrays.asList(new BodySlam(), new Crunch(), new RapidAttack(), new Slam(), new SuperPower(), new Tackle(), new Thunder(), new Thunderbolt()));
                moveList.stream().forEach(m -> {
                    try {
                        connToPukemonDB.prepareStatement(upsertTable("Moves", new Column[]{
                                new Column<String>("name", m.getName()),
                                new Column<Integer>("damage", m.getDamage()),
                                new Column<Integer>("accuracy", m.getAccuracy()),
                                new Column<Integer>("velocity", m.getVelocity()),
                                new Column<Integer>("probabilityToSufferEffect", m.getProbabilityToSufferEffect()),
                                new Column<String>("effect", m.getEffect().toString())
                        })).execute();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

                //LISTA DI ACCOPPIAMENTI TRA PUKEMON E MOVES
                pokemonList.stream().forEach(p -> {
                    try {
                        for (int i = 0; i < p.getMoves().length; i++) {
                            Move m = p.getMoves()[i];
                            connToPukemonDB.prepareStatement(upsertTable("Pukemon_Moves", new Column[]{
                                    new Column<String>("pname", p.getName()),
                                    new Column<String>("mname", m.getName())
                            })).execute();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                });

                /*CLOSE CONNECTION*/
                connToPukemonDB.close();

            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("IMPOSSIBILE CONNETTERSI AL DATABASE");
            }
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            throw new RuntimeException("IMPOSSIBILE CREARE IL DATABASE");
        }

    }//static

    private static String createTable(String tableName, Column[] columns) {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName +
                "(id INT(11) UNSIGNED PRIMARY KEY AUTO_INCREMENT";
        for (Column c : columns) {
            sql += ", " + c.getName() + " " +
                    c.getValueForDB() + "(" +
                    c.getLength() + ")" +
                    c.getFillZero() + " " +
                    c.getSigned() + " " +
                    c.getNullAllowance() + " " +
                    c.getUnique() + " " +
                    c.getPrimaryKey();
        }
        sql += ")";
        System.out.println(logger.write(sql));
        return sql;
    }

    private static String alterTableForeignKey(String tableOrigin, String tableTarget, String originName, String targetName) {
        String fk = "FK_" + tableOrigin + "_" + tableTarget;
        String sql = "ALTER TABLE " + tableOrigin +
                " ADD CONSTRAINT " + fk +
                " FOREIGN KEY (" + originName + ") " +
                "REFERENCES " + tableTarget +
                "("+targetName+")" +
                " ON DELETE CASCADE";
        System.out.println(logger.write(sql));
        return sql;
    }

    private static String upsertTable(String tableName, Column[] columns) {
        String sql = "INSERT INTO " + tableName + "(" + tableName + ".";
        for (Column c : columns) {
            sql += c.getName() + ", ";
        }
        sql = sql.trim().substring(0, sql.length() - 2);
        sql += ") VALUES(";
        for (Column c : columns) {
            switch (c.getValueForDB()) {
                case "INT":
                case "BIGINT":
                case "DOUBLE":
                case "DECIMAL":
                    sql += c.getValue() + ", ";
                    break;
                default:
                    sql += "\"" + c.getValue() + "\", ";
                    break;
            }
        }
        sql = sql.trim().substring(0, sql.length() - 2) + ")";
        sql += " ON DUPLICATE KEY UPDATE ";
        for (Column c : columns) {
            sql += tableName + "." + c.getName() + " = VALUES(" + tableName + "." + c.getName() + ")" + ", ";
        }
        sql = sql.trim().substring(0, sql.length() - 2);
        System.out.println(logger.write(sql));
        return sql;
    }

    private static String deleteRow(String tableName, String name) {
        String sql = "DELETE FROM " + tableName + " WHERE " + tableName + ".name = " + "\"" + name + "\"";
        System.out.println(logger.write(sql));
        return sql;
    }

    private static String deleteTable(String tableName) {
        String sql = "DELETE FROM " + tableName;
        System.out.println(logger.write(sql));
        return sql;
    }

}//end class
