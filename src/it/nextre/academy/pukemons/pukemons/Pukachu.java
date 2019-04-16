package it.nextre.academy.pukemons.pukemons;

import it.nextre.academy.pukemons.moves.*;

public class Pukachu extends Pukemon {

    private static final Move[] mossePukachu = new Move[]{
        new RapidAttack(), new Slam(), new Thunderbolt(), new Thunder()
    };
    private static final String name = "Pukachu";
    private static final int hitPoints = 75;
    private static final int armor = 1;
    private static final int attack = 20;

    public Pukachu() {
        super(name, hitPoints, armor, attack, mossePukachu);
    }
}//end class
