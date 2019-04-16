package it.nextre.academy.esercizi.es1;

public class Cicli {

    static int pippo = 15;
    static int carlo = 30;
    static int salvatore = 0;

    public static void main(String[] args) {

        while(pippo > salvatore){
            System.out.println("salvatore");
            carlo = pippo + salvatore;
            salvatore++;
        }

    }//end main

}//end class
