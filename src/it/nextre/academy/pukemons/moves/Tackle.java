package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;

public class Tackle extends Move{

    private static final String name = getSimpleName();
    private static final int damage = 40;
    private static final int precision = 100;
    private static final int velocity = 80;
    private static final Effect effect = Effect.NONE;
    private static final int probabilityToSufferEffect = 0;

    public Tackle() {
        super(name, damage, precision, velocity, effect, probabilityToSufferEffect);
    }

    private static String getSimpleName(){
        return Tackle.class.getSimpleName();
    }
}//end class
