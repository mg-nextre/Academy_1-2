package it.nextre.academy.esercizi.conto_bancario;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Account jerryPippo = new Account("Jerry","Scotti","PIPPO90", LocalDateTime.of(1934,12,9,3,54,0),"PippoPlutoPaperino",12345);

        Account momsSavings = new Account("Mamma","X","Giovanni", LocalDateTime.of(1934,12,9,3,54,0),"PaoloGiacomo",67890);

        Scanner scanner = new Scanner(System.in);
        int pin = 0;

        try{
            System.out.println("Inserisci il tuo pin per l'autorizzazione");
            pin = scanner.nextInt();
            jerryPippo.operazione(1000d,true,pin);
            jerryPippo.operazione(500d,false,pin);
            jerryPippo.operazione(400d,false,pin);
            System.out.println(jerryPippo.getSaldo());
        }catch(RuntimeException rte){
            rte.printStackTrace();
        }

        pin = 0;

        try{
            System.out.println("Inserisci il tuo pin per l'autorizzazione");
            pin = scanner.nextInt();
            momsSavings.operazione(1000d,true, pin);
            momsSavings.calcolaInteressi(0.1);
            System.out.println(momsSavings.getSaldo());
            System.out.println(jerryPippo.getIBAN());
        }catch(RuntimeException rte){
            rte.printStackTrace();
        }

    }//end main
}//end class
