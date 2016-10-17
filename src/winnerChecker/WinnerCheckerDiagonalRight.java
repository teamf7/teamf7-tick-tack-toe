package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerDiagonalRight implements WinnerCheckerInterface {
    private GameField board;
    private int winnerCount = 0;
    public WinnerCheckerDiagonalRight(GameField gameField,int winnerCount) {
        this.board = gameField;
        this.winnerCount = winnerCount;
    }

    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer = null;
        int successCounter = 1;
        for (int i = 0, len = board.getN(); i < len; i++) {
            currentPlayer = board.getValue(i, len - (i+1));
            if (currentPlayer == lastPlayer && (currentPlayer != null && lastPlayer != null)) {
                successCounter++;
                if (successCounter == len ||(winnerCount != 0 && winnerCount == successCounter)) {
                    return currentPlayer;
                }
            }
            lastPlayer = currentPlayer;
        }
        return null;
    }
}