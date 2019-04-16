package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;

public class Thunderbolt extends Move{

    private static final String name = getSimpleName();
    private static final int damage = 120;
    private static final int precision = 100;
    private static final int velocity = 100;
    private static final Effect effect = Effect.PARALYZE;
    private static final int probabilityToSufferEffect = 20;

    public Thunderbolt() {
        super(name, damage, precision, velocity, effect, probabilityToSufferEffect);
    }

    private static String getSimpleName(){
        return Thunderbolt.class.getSimpleName();
    }
}//end class
