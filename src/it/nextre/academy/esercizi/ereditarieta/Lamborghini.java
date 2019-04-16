package it.nextre.academy.esercizi.ereditarieta;

public class Lamborghini extends Auto{

    public Lamborghini(){
        super(4);
    }

    @Override
    public void muoviti() {
        System.out.println("Lamborghini: mi sto muovendo");
    }
}//end class
