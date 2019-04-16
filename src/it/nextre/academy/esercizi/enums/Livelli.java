package it.nextre.academy.esercizi.enums;

public enum Livelli {

    MAX(10), MEDIO(5), MIN(0){
        public int pippo = 5;
        @Override
        public void stampaValore(){
            System.out.println("Minimo"+pippo);
        }
    };


    static{
        System.out.println("Enum Livelli caricata");
    }
    {
        System.out.println("Enum Livelli pre-istanziata");
    }

    Livelli(int p){
        System.out.println("Costruttore Enum Livelli");
    }

    //metodo comune
    public void stampaValore(){
        System.out.println("Medio");
    }

}//end class
