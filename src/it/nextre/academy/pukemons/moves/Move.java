package it.nextre.academy.pukemons.moves;

import it.nextre.academy.pukemons.effects.Effect;
import it.nextre.academy.pukemons.logger.Logger;
import it.nextre.academy.pukemons.pukemons.Pukemon;
import it.nextre.academy.pukemons.vocabolaries.UtilityStringFormatter;

import java.io.IOException;
import java.util.Random;

public abstract class Move {

    private String name;
    private int damage;
    private int accuracy;
    private int velocity;
    private Effect effect;
    private int probabilityToSufferEffect;

    private static final Logger logger = Logger.getInstance();

    public Move(String name, int damage, int accuracy, int velocity, Effect effect, int probabilityToSufferEffect) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
        this.velocity = velocity;
        this.effect = effect;
        this.probabilityToSufferEffect = probabilityToSufferEffect;
    }

    public void execute(Effect myEffect, int myAttack, Pukemon adversary) throws IOException {
        System.out.println(logger.write(UtilityStringFormatter.getPukeMoveUsed(name)));
        if(myEffect != Effect.PARALYZE) {
            Random r = new Random();
            if (r.nextInt(101) <= accuracy) {
                int dmg = calculateDamage(myAttack, adversary.getArmor());
                adversary.getHit(dmg);
                System.out.println(logger.write(UtilityStringFormatter.getHitPointsAttackInfo(dmg, adversary.getHitPoints())));
                if (r.nextInt(101) <= probabilityToSufferEffect) {
                    if (adversary.getSufferingEffect() == Effect.NONE) {
                        adversary.applyEffect(effect);
                        System.out.println(logger.write(UtilityStringFormatter.getOpponentApplyEffect(adversary.getSufferingEffect()+"")));
                    }
                }
            }else System.out.println(logger.write(UtilityStringFormatter.getPukeMissed()));
        }else System.out.println(logger.write(UtilityStringFormatter.getPukeParalyzed()));
        return ;
    }

    private int calculateDamage(int myAttack, int enemyArmor){
        return ((this.damage * myAttack)/enemyArmor)/100;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getVelocity() {
        return velocity;
    }

    public Effect getEffect() {
        return effect;
    }

    public int getProbabilityToSufferEffect() {
        return probabilityToSufferEffect;
    }

    @Override
    public String toString() {
        return "Move{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", accuracy=" + accuracy +
                ", velocity=" + velocity +
                ", effect=" + effect +
                ", probabilityToSufferEffect=" + probabilityToSufferEffect +
                '}';
    }
}//end class
