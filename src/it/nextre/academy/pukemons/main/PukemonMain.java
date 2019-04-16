package it.nextre.academy.pukemons.main;

import java.io.IOException;

public class PukemonMain {

    public static void main(String[] args) {

        //new ProcessBuilder("C:/Program Files/audacity-win-2.3.0/audacity.exe").start();
        //System.out.println(new ProcessBuilder().command());
        //Runtime.getRuntime().exec("C:/Program Files/audacity-win-2.3.0/audacity.exe");

        //System.out.println(String.class.getSimpleName());

        try {
            PukemonGame.getInstance().playGame();
        } catch (IOException e) {
            e.printStackTrace();
        }//catch

    }//end main

}//end class
