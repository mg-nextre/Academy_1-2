package it.nextre.academy.pukemons.pukemons;

import it.nextre.academy.pukemons.effects.Effect;
import it.nextre.academy.pukemons.logger.Logger;
import it.nextre.academy.pukemons.moves.Move;
import it.nextre.academy.pukemons.vocabolaries.UtilityStringFormatter;

import java.io.IOException;
import java.util.Arrays;

public abstract class Pukemon {

    private static Logger logger = Logger.getInstance();

    //PERSISTENT
    private String name;
    private int hitPoints;
    private int armor;
    private int attack; //from 0 to Infinity
    private Move[] moves;

    //NOT PERSISTENT
    private boolean fainted;
    private Effect sufferingEffect;


    public Pukemon(String name, int hitPoints, int armor, int attack, Move[] moves) {
        this.name = name;
        this.hitPoints = (hitPoints <= 0) ? 100 : hitPoints;
        this.armor = armor;
        this.attack = attack;
        this.fainted = false;
        this.sufferingEffect = Effect.NONE;
        this.moves = moves;
    }

    public int getAttack() {
        return attack;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getArmor() {
        return armor;
    }

    public boolean isFainted() {
        return fainted;
    }

    public Effect getSufferingEffect() {
        return sufferingEffect;
    }

    public Move[] getMoves() {
        return moves;
    }

    public void getHit(int dmgAmount) throws IOException {
        hitPoints -= dmgAmount;
        faint();
    }

    public void sufferFromEffect() throws IOException {
        getHit(sufferingEffect.damage());
    }

    private void faint() throws IOException {
        if(hitPoints <= 0){
            fainted = true;
            System.out.println(logger.write(UtilityStringFormatter.getPukeFainted(name)));
        }
    }

    public void applyEffect(Effect effect){
        this.sufferingEffect = effect;
    }

    public void clearEffect(){
        this.sufferingEffect = Effect.NONE;
    }

    @Override
    public String toString() {
        return "Pukemon{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", armor=" + armor +
                ", attack=" + attack +
                ", fainted=" + fainted +
                ", sufferingEffect=" + sufferingEffect +
                ", moves=" + Arrays.toString(moves) +
                '}';
    }

    /*DA METTERE IN UTILITYSTRINGFORMATTER*/
    public String toStringMosse(){
        Integer i = 1;
        StringBuilder nameMoves = new StringBuilder("|* "+i+".");
        for(Move move : moves){
            nameMoves = nameMoves.append(move.getName());
            nameMoves = nameMoves.append(++i > 4 ? " *|" : " "+(i)+".");
        }
        return nameMoves.toString();
        /*return Arrays.asList(moves).stream().map(mossa -> mossa.getName()).collect(Collectors.joining(", ","|* "," *|"));*/
    }
}//end class
