package it.nextre.academy.pukemons.effects;

import java.util.Random;

public enum Effect {
    BURN,PARALYZE{
        @Override
        public int damage() {
            return 0;
        }
    },POISON{
        @Override
        public int damage() {
            return new Random().nextInt(3)+1;
        }
    }, NONE{
        @Override
        public int damage() {
            return 0;
        }
    };

    public int damage(){
        return new Random().nextInt(2)+1;
    }

}//end enum
