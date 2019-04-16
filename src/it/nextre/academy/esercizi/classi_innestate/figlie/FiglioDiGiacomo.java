package it.nextre.academy.esercizi.classi_innestate.figlie;

import it.nextre.academy.esercizi.classi_innestate.Giacomo;

public class FiglioDiGiacomo extends Giacomo {

    public static void main(String[] args) {

        Giacomo g = new Giacomo();
        System.out.println(g.a);
        //System.out.println(g.b);
        //System.out.println(g.c);

        FiglioDiGiacomo f = new FiglioDiGiacomo();
        System.out.println(f.a);
        System.out.println(f.b);
        //System.out.println(f.c);
        //System.out.println(f.d);

    }//end main

}//end class
