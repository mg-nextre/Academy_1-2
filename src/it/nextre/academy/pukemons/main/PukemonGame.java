package it.nextre.academy.pukemons.main;

import it.nextre.academy.pukemons.db.PukemonDAO;
import it.nextre.academy.pukemons.errors.FaintedRuntimeException;
import it.nextre.academy.pukemons.logger.Logger;
import it.nextre.academy.pukemons.pukemons.Pukachu;
import it.nextre.academy.pukemons.pukemons.Pukemon;
import it.nextre.academy.pukemons.pukemons.Snurlax;
import it.nextre.academy.pukemons.vocabolaries.UtilityStringFormatter;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class PukemonGame {

    private static Scanner scanner = new Scanner(System.in);
    private static PukemonGame pukemonGame = null;
    private static final Logger logger = Logger.getInstance();
    //private static final UtilityStringFormatter vocabolary = new UtilityStringFormatter();

    /*TEST*/
    PukemonDAO pukemonDAO = new PukemonDAO();
    /*TEST*/

    private PukemonGame() {}

    public static synchronized PukemonGame getInstance() {
        if(pukemonGame == null){
            pukemonGame = new PukemonGame();
        }
        return pukemonGame;
    }

    public void playGame() throws IOException {

        System.out.println(logger.write(UtilityStringFormatter.getWelcome()));

        Pukemon p1 = new Snurlax(); // Paolo
        Pukemon p2 = new Pukachu();

        while(!p1.isFainted() && !p2.isFainted()){
            System.out.println(logger.write(UtilityStringFormatter.getChoice()));
            System.out.println(logger.write(UtilityStringFormatter.getMoves()));
            System.out.println(p1.toStringMosse());/*DA METTERE A POSTO CON UTILITYSTRINGFORMATTER*/

            try{
                bothAttacks(checkInput(),p1,p2);
            }catch(FaintedRuntimeException fre){
                break;
            }

            endTurn(p1);
            endTurn(p2);

        }//while

        scanner.close();
        System.out.println(logger.write(UtilityStringFormatter.getEnding()));
    }

    private static void bothAttacks(Integer numMove, Pukemon pukemon1, Pukemon pukemon2) throws IOException {

        Integer pcMove = new Random().nextInt(4);

        if(pukemon1.getMoves()[numMove-1].getVelocity() > pukemon2.getMoves()[pcMove].getVelocity()){
            executeMove(numMove,pukemon1,pukemon2);
            if(pukemon2.isFainted()) throw new FaintedRuntimeException();
            computerExecuteMove(pcMove,pukemon1,pukemon2);
            if(pukemon1.isFainted()) throw new FaintedRuntimeException();
        }else{
            computerExecuteMove(pcMove,pukemon1,pukemon2);
            if(pukemon1.isFainted()) throw new FaintedRuntimeException();
            executeMove(numMove,pukemon1,pukemon2);
            if(pukemon2.isFainted()) throw new FaintedRuntimeException();
        }//else
    }//bothAttacks

    private static void computerExecuteMove(Integer numMove, Pukemon pukemon1, Pukemon pukemon2) throws IOException {
        System.out.println(logger.write(UtilityStringFormatter.getOpponentPukeAttack()));
        pukemon2.getMoves()[numMove].execute(pukemon2.getSufferingEffect(),pukemon2.getAttack(),pukemon1);
    }

    private static void executeMove(Integer numMove, Pukemon pukemon1, Pukemon pukemon2) throws IOException {
        System.out.println(logger.write(UtilityStringFormatter.getMyPukeAttack()));
        pukemon1.getMoves()[numMove-1].execute(pukemon1.getSufferingEffect(),pukemon1.getAttack(),pukemon2);
    }

    private static int checkInput() throws IOException {
        try{
            Integer numMove = scanner.nextInt();
            if (numMove < 1 || numMove > 4) throw new RuntimeException();
            return numMove;
        }catch(RuntimeException re){
            scanner = new Scanner(System.in);
            System.err.println(logger.write(UtilityStringFormatter.getErrors()));
            return checkInput();
        }
    }

    private static void endTurn(Pukemon pukemon1) throws IOException {

        switch(pukemon1.getSufferingEffect()){
            case NONE:
                break;
            default:
                if(new Random().nextInt(101) <= 50)
                    pukemon1.clearEffect();
                else {
                    pukemon1.sufferFromEffect();
                    System.out.println(logger.write(UtilityStringFormatter.getSufferingFromEffect(pukemon1.getName(), pukemon1.getSufferingEffect()+"")));
                }//else
                break;
        }//switch
    }//endturn

}//end class
