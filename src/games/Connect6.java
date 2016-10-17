package games;

import exception.GameException;
import exception.GameOverException;
import game.Step;
import game.TwoPlayersGame;
import winnerChecker.WinnerCheckerDiagonalBottomLeft;
import winnerChecker.WinnerCheckerDiagonalBottomRight;
import winnerChecker.WinnerCheckerDiagonalTopLeft;
import winnerChecker.WinnerCheckerDiagonalTopRight;

import java.util.Random;


/**
 * Created by admin on 16.10.2016.
 */
public class Connect6 extends TwoPlayersGame{
    private int stepPlayer=0;
    private int randomNumber;
    public Connect6() {
        super(15,6);
    }
    public Connect6(int rand) {
        super(15,6);
        this.randomNumber = rand;
    }
    @Override
    public void start() throws GameException{
        super.start();
        makeRandom(randomNumber);
        stepPlayer = 0;
    }
    public void makeRandom(int rand) throws GameException {
        final Random random = new Random();
        for(int i = 0; i< rand; i++){
            int x =  random.nextInt(15);
            int y =  random.nextInt(15);
            if(getHistory().contains(new Step(x,y))){
                continue ;
            }
                makeStep(new Step(x,y));
        }
    }

    @Override
    public void switchPlayers()  throws GameOverException {
        if(stepPlayer==0){
            super.switchPlayers();
        }
        stepPlayer++;
        if(stepPlayer==3){
            super.switchPlayers();
            stepPlayer=1;
        }
    }
    @Override
    public void initialization(int successFilled){
        super.initialization(successFilled);
        getWinnerCheckers().add(new WinnerCheckerDiagonalTopLeft(getGameField(), successFilled));
        getWinnerCheckers().add(new WinnerCheckerDiagonalBottomLeft(getGameField(), successFilled));
        getWinnerCheckers().add(new WinnerCheckerDiagonalTopRight(getGameField(), successFilled));
        getWinnerCheckers().add(new WinnerCheckerDiagonalBottomRight(getGameField(), successFilled));
    }


}
