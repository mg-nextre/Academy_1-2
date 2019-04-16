package it.nextre.academy.esercizi.classi_innestate;

public class Padre extends Object{
    enum Sesso{
        M,F,ALTRO;

        Sesso(){}

        public void f(){}
    }

    private Sesso s;

    public Padre(Sesso s) {
        super();
        this.s = s;
    }

    public Sesso getSesso(){
        return s;
    }

    public static void main(String[] args) {
        Sesso g = Sesso.ALTRO;
    }//end main

}//end class

class Pippo{}
enum coda{}
interface gg{}
abstract class popo{}