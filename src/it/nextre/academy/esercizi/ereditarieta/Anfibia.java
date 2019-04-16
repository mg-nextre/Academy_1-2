package it.nextre.academy.esercizi.ereditarieta;

public interface Anfibia {

    boolean hasTracks = false;

    void guada(String riga);

    static void inceppati(){
        System.out.println("Mi sono inceppato");
    }

    default void rompiti(){
        System.out.println("Mi sono rotto!");
    }

}//end interface
