package it.nextre.academy.esercizi.ereditarieta;

import java.math.BigDecimal;
import java.util.Scanner;

public class Panda extends Auto implements Anfibia{

    public Panda(){
        super(5);
        System.out.println("Panda creata");
    }

    private String colore = "blu";
    private String trazione = "4x4";
    private boolean indistruttibile = true;

    public static void main(String[] args) {

        /*System.out.println(new Panda().getnRuote());

        new Panda().muoviti();

        //new Veicolo();

        Veicolo[] pippo = {new Lamborghini(), new Panda()};

        for(Veicolo pippone : pippo){
            pippone.muoviti();
        }*/

        /*Veicolo v = new Veicolo() {
            @Override
            public void muoviti() {
                System.out.println(pippo);
            }
            public int pippo;
        };

        v.muoviti();

        Anfibia anfibia = new Anfibia() {
            int pippo;
            @Override
            public void guada(String riga) {
                System.out.println(riga);
            }
        };

        Anfibia aaaa = System.out::println;

        aaaa.guada("Paolo non dormire");*/

        /*Auto automobile = new Panda();
        automobile.sterza();*/

        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Scrivi int ");
        int i = scanner.nextInt();
        System.out.println("Scrivi String");
        String s = scanner.next();
        scanner.remove();
        scanner.reset();
        //int ii = scanner.nextInt();
        System.out.println("Bravo");*/

    }//end main

    @Override
    public void guada(String riga) {
        System.out.println(riga);
    }

    @Override
    public void rompiti() {

    }
    public void rompiti(String pippo){

    }
    public String rompiti(int i){
        return ""+i;
    }

    @Override
    public void sterza() {
        System.out.println("Panda: Sto sterzando");
    }

    @Override
    public void muoviti() {
        System.out.println("Panda: Mi sto muovendo");
    }
    public String getColore() {
        return colore;
    }
    public void setColore(String colore) {
        this.colore = colore;
    }
    public String getTrazione() {
        return trazione;
    }
    public void setTrazione(String trazione) {
        this.trazione = trazione;
    }
    public boolean isIndistruttibile() {
        return indistruttibile;
    }
    public void setIndistruttibile(boolean indistruttibile) {
        this.indistruttibile = indistruttibile;
    }

}//end class
