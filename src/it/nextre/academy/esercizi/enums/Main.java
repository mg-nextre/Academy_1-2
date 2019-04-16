package it.nextre.academy.esercizi.enums;

public class Main {

    public static void main(String[] args) {

        Livelli livelli = Livelli.MAX;
        Livelli livelloBasso = Livelli.MIN;

        livelli.stampaValore();
        livelloBasso.stampaValore();

        scegli(Livelli.MEDIO);

    }//end main

    public static void scegli(Livelli level){
        switch (level){
            case MAX:
                System.out.println("Switch: MAX");
                break;
            case MEDIO:
                System.out.println("Switch: Medio");
                break;
            case MIN:
                System.out.println("Switch: MIN");
                break;
            default:
                System.out.println("DEFAULT");
        }
    }

}//end class
