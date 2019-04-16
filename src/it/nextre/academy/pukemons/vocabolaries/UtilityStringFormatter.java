package it.nextre.academy.pukemons.vocabolaries;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public final class UtilityStringFormatter {

    private static final List<String> listWelcome = new ArrayList<>(Arrays.asList("BENVENUTO ALLA LEGA PUKEMON, STRONZO"));
    private static final List<String> listChoice = new ArrayList<>(Arrays.asList("SCEGLI LA TUA MOSSA, STRONZO"));
    private static final List<String> listMoves = new ArrayList<>(Arrays.asList("ELENCO MOSSE:"));
    private static final List<String> listEnding = new ArrayList<>(Arrays.asList("FINE"));
    private static final List<String> listMyPukeAttack = new ArrayList<>(Arrays.asList("---Your pukemons is preparing to attack!---"));
    private static final List<String> listOpponentPukeAttack = new ArrayList<>(Arrays.asList("---Your opponent is preparing to attack!---"));
    private static final List<String> listErrors = new ArrayList<>(Arrays.asList("INPUT NON VALIDO: REINSERISCI IL NUMERO DELLA MOSSA, STRONZO"));
    private static final List<String> listSufferingFromEffect = new ArrayList<>(Arrays.asList(" is suffering from "));
    private static final List<String> listPukeFainted = new ArrayList<>(Arrays.asList("!- Pukemon $1 fainted -!"));
    private static final List<String> listPukeMoveUsed = new ArrayList<>(Arrays.asList("The pukemons used "));
    private static final List<String> listHitPointsAttackInfo = new ArrayList<>(Arrays.asList("The opponent has been hit with $1 damage points and has $2 remaining hit points"));
    private static final List<String> listOpponentApplyEffect = new ArrayList<>(Arrays.asList("The opponent is now $1ED"));
    private static final List<String> listPukeMissed = new ArrayList<>(Arrays.asList("The pukemons has missed!"));
    private static final List<String> listPukeParalyzed = new ArrayList<>(Arrays.asList("The pukemons is paralyzed, is unable to move!"));



    public static String getWelcome() {
        return listWelcome.get(new Random().nextInt(listWelcome.size()));
    }//getWelcome

    public static String getChoice() {
        return listChoice.get(new Random().nextInt(listChoice.size()));
    }//getChoice

    public static String getMoves() {
        return listMoves.get(new Random().nextInt(listMoves.size()));
    }//getMoves

    public static String getEnding() {
        return listEnding.get(new Random().nextInt(listEnding.size()));
    }//getEnding

    public static String getMyPukeAttack() {
        return listMyPukeAttack.get(new Random().nextInt(listMyPukeAttack.size()));
    }//getMyPukeAttack

    public static String getOpponentPukeAttack() {
        return listOpponentPukeAttack.get(new Random().nextInt(listOpponentPukeAttack.size()));
    }//getOpponentPukeAttack

    public static String getErrors() {
        return listErrors.get(new Random().nextInt(listErrors.size()));
    }//getErrors

    public static String getSufferingFromEffect(String pre, String post) {
        return pre+listSufferingFromEffect.get(new Random().nextInt(listSufferingFromEffect.size()))+post;
    }//getSufferingFromEffect

    public static String getPukeFainted(String name) {
        return listPukeFainted.get(new Random().nextInt(listPukeFainted.size())).replaceFirst("\\$1", name);
    }//getPukeFainted

    public static String getPukeMoveUsed(String moveName) {
        return listPukeMoveUsed.get(new Random().nextInt(listPukeMoveUsed.size()))+moveName;
    }//getPukeMoveUsed

    public static String getHitPointsAttackInfo(int dmg, int hitPoints) {
        return listHitPointsAttackInfo.get(new Random().nextInt(listHitPointsAttackInfo.size())).replaceFirst("\\$1", dmg+"").replaceFirst("\\$2", hitPoints+"");
    }//getHitPointsAttackInfo

    // da mettere a posto quando è !!!--- paralyzeed ---!!!
    public static String getOpponentApplyEffect(String sufferingEffect) {
        return listOpponentApplyEffect.get(new Random().nextInt(listOpponentApplyEffect.size())).replaceFirst("\\$1", sufferingEffect);
    }//getOpponentApplyEffect

    public static String getPukeMissed() {
        return listPukeMissed.get(new Random().nextInt(listPukeMissed.size()));
    }//getPukeMissed

    public static String getPukeParalyzed() {
        return listPukeParalyzed.get(new Random().nextInt(listPukeParalyzed.size()));
    }//getPukeParalyzed


}//end class
