package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;

public class Thunder extends Move{

    private static final String name = getSimpleName();
    private static final int damage = 200;
    //8====D
    private static final int precision = 60;
    private static final int velocity = 50;
    private static final Effect effect = Effect.PARALYZE;
    private static final int probabilityToSufferEffect = 30;

    public Thunder() {
        super(name, damage, precision, velocity, effect, probabilityToSufferEffect);
    }

    private static String getSimpleName(){
        return Thunder.class.getSimpleName();
    }
}//end class
