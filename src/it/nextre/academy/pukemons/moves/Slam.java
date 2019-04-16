package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;

public class Slam extends Move{

    private static final String name = getSimpleName();
    private static final int damage = 70;
    private static final int precision = 75;
    private static final int velocity = 100;
    private static final Effect effect = Effect.NONE;
    private static final int probabilityToSufferEffect = 0;

    public Slam() {
        super(name, damage, precision, velocity, effect, probabilityToSufferEffect);
    }

    private static String getSimpleName(){
        return Slam.class.getSimpleName();
    }
}//end class
