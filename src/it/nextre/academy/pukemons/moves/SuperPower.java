package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;

public class SuperPower extends Move{

    private static final String name = getSimpleName();
    private static final int damage = 120;
    private static final int precision = 70;
    private static final int velocity = 40;
    private static final Effect effect = Effect.NONE;
    private static final int probabilityToSufferEffect = 0;

    public SuperPower() {
        super(name, damage, precision, velocity, effect, probabilityToSufferEffect);
    }

    private static String getSimpleName(){
        return SuperPower.class.getSimpleName();
    }

}//end class
