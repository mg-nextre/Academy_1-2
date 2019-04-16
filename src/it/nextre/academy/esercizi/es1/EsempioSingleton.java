package it.nextre.academy.esercizi.es1;

public class EsempioSingleton {

    private static EsempioSingleton instance = null;

    private EsempioSingleton(){
        System.out.println("Sono stato generato");
    }//costruttore

    public static EsempioSingleton getInstance(){
        if(instance == null){
            instance = new EsempioSingleton();
        }
        return instance;
    }

}//end class
