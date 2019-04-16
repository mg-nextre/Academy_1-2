package it.nextre.academy.esercizi.classi_innestate.classi_anonime;

@FunctionalInterface
public interface IDado {

    //void tr();
    void lancia();

    static void metodoStatico(){
        System.out.println("metodo statico");
    }

    default void metodoDefault(){
        System.out.println("metodo di default");
    }

    default Integer conta(){
        return 10;
    }

}//end interface
