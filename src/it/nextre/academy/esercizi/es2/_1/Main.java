package it.nextre.academy.esercizi.es2._1;

import java.time.Duration;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try(Scanner scanner = new Scanner(System.in)){
            //Scanner scanner = new Scanner(System.in);
            System.out.println("Inserire il numero di giorni, ore, minuti e secondi, gg-hh-mm-ss");

            String all = scanner.nextLine();
            String[] arrayTime = all.split("-");

            if(all.length() == arrayTime[0].length() || arrayTime.length != 4) throw new IllegalArgumentException("No dashes found inside the values inserted or not enough values");

            System.out.println(Duration.parse("P"+arrayTime[0]+"DT"+arrayTime[1]+"H"+arrayTime[2]+"M"+arrayTime[3]+"S").getSeconds());
        }catch(DateTimeParseException | IllegalArgumentException dtpe){
            System.err.println(dtpe.getMessage());
        }catch(RuntimeException re){
            System.err.println(re.getMessage());
        }

    }//end main

}//end class
