package games;

import exception.GameException;
import exception.GameOverException;
import game.TwoPlayersGame;
import winnerChecker.*;

/**
 * Created by admin on 16.10.2016.
 */
public class Connect6 extends TwoPlayersGame{
    private int stepPlayer=0;
    private int successFilled;

    public Connect6() {
        super(15);
        successFilled = 6;
    }

    @Override
    public void start() throws GameException{
        super.start();
        stepPlayer = 0;
    }


    @Override
    public void switchPlayers()  throws GameOverException {
        if(stepPlayer == 0){
            super.switchPlayers();
        }
        stepPlayer++;
        if(stepPlayer == 3){
            super.switchPlayers();
            stepPlayer = 1;
        }
    }
    @Override
    public void initialization(){
        super.initialization();
        getWinnerCheckers().add(new WinnerCheckerHorizontal(getGameField(),successFilled));
        getWinnerCheckers().add(new WinnerCheckerVertical(getGameField(), successFilled));
        getWinnerCheckers().add(new WinnerCheckerDiagonalTopLeft(getGameField(), successFilled));
        getWinnerCheckers().add(new WinnerCheckerDiagonalBottomLeft(getGameField(), successFilled));
        getWinnerCheckers().add(new WinnerCheckerDiagonalTopRight(getGameField(), successFilled));
        getWinnerCheckers().add(new WinnerCheckerDiagonalBottomRight(getGameField(), successFilled));
    }


}
