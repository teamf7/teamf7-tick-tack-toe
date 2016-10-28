package games;

import exception.GameException;
import game.Player;
import game.Step;
import game.TwoPlayersGame;
import winnerChecker.WinnerCheckerDiagonalLeft;
import winnerChecker.WinnerCheckerDiagonalRight;
import winnerChecker.WinnerCheckerHorizontal;
import winnerChecker.WinnerCheckerVertical;

/**
 * Created by designAi on 16.10.2016.
 */
public class TicTacToe extends TwoPlayersGame{

    public TicTacToe() {
        super(3);
    }

    @Override
    public void initialization(){
        super.initialization();
        getWinnerCheckers().add(new WinnerCheckerHorizontal(getGameField()));
        getWinnerCheckers().add(new WinnerCheckerVertical(getGameField()));
        getWinnerCheckers().add(new WinnerCheckerDiagonalLeft(getGameField()));
        getWinnerCheckers().add(new WinnerCheckerDiagonalRight(getGameField()));
    }

}
