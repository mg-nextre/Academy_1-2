package it.nextre.academy.esercizi.es1;

public class Esercizio {

    private int numero = 2;
    int ugo = 4;
    protected int sara = 6;
    public int giacomo = 8;

    public static void main(String[] args) {

        int gigi = 3;

        switch (gigi){
            case 1:
                System.out.println("1");
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
            default:
                System.out.println("Default");
                break;
        }//end switch

    }//end main

}//end class
