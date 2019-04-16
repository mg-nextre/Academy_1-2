package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;

public class BodySlam extends Move{

    private static final String name = getSimpleName();
    private static final int damage = 100;
    private static final int precision = 80;
    private static final int velocity = 50;
    private static final Effect effect = Effect.NONE;
    private static final int probabilityToSufferEffect = 0;

    public BodySlam() {
        super(name, damage, precision, velocity, effect, probabilityToSufferEffect);
    }

    private static String getSimpleName(){
        return BodySlam.class.getSimpleName();
    }
}//end class
