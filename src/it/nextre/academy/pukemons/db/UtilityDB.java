package it.nextre.academy.pukemons.db;

import java.util.HashMap;
import java.util.Map;

public class UtilityDB {

    /*private static List<String> mySQLAllowedTypes = Arrays.asList("INT","BIGINT");
    private static List<String> mySQLAllowedTypesDouble = Arrays.asList("DOUBLE","DECIMAL");
    private static List<String> mySQLAllowedTypesString = Arrays.asList("CHAR","VARCHAR","TEXT","LONGTEXT","JSON");
    private static List<String> mySQLAllowedTypesBinary = Arrays.asList("VARBINARY","BLOB","LONGBLOB");
    private static List<String> mySQLAllowedTypesTemporal = Arrays.asList("DATE","DATETIME","YEAR","TIMESTAMP");*/

    private static Map<String, String> mySQLAllowedTypes = new HashMap<>();

    static{
        mySQLAllowedTypes.put("Integer","INT");
        mySQLAllowedTypes.put("Long","BIGINT");
        mySQLAllowedTypes.put("Double","DOUBLE");
        mySQLAllowedTypes.put("BigDecimal","DECIMAL");
        mySQLAllowedTypes.put("String","VARCHAR");
    }

    public static String getAllowedType(Class objectClass){
        return mySQLAllowedTypes.get(objectClass.getSimpleName());
    }

}//end class
