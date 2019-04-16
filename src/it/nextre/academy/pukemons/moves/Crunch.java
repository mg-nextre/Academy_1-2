package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;

public class Crunch extends Move{

    private static final String name = getSimpleName();
    private static final int damage = 80;
    private static final int precision = 100;
    private static final int velocity = 60;
    private static final Effect effect = Effect.NONE;
    private static final int probabilityToSufferEffect = 0;

    public Crunch() {
        super(name, damage, precision, velocity, effect, probabilityToSufferEffect);
    }

    private static String getSimpleName(){
        return Crunch.class.getSimpleName();
    }
}//end class
