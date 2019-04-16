package it.nextre.academy.pukemons.pukemons;

import it.nextre.academy.pukemons.moves.*;

public class Snurlax extends Pukemon {

    private static final Move[] moves = new Move[]{
            new Tackle(), new BodySlam(), new Crunch(), new SuperPower()
    };
    private static final String name = "Snurlax";
    private static final int hitPoints = 200;
    private static final int armor = 2;
    private static final int attack = 5;

    public Snurlax() {
        super(name, hitPoints, armor, attack, moves);
    }
}//end class
