package it.nextre.academy.utilities.banca;

import java.util.UUID;

public class UtilityBanca {

    public static String generateIBAN(){
        return UUID.randomUUID().toString();
    }

}//end class
