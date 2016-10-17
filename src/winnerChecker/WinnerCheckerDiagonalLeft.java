package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerDiagonalLeft implements WinnerCheckerInterface {
    private GameField gameField;
    private int winnerCount;
    public WinnerCheckerDiagonalLeft(GameField gameField, int winnerCount) {
        this.gameField = gameField;
        this.winnerCount = winnerCount;
    }

    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer = null;
        int successCounter = 1;
        for (int i = 0, len = gameField.getN(); i < len; i++) {
            currentPlayer = gameField.getValue(i,i);
            if (currentPlayer == lastPlayer && (currentPlayer != null && lastPlayer != null)) {
                successCounter++;
                if (successCounter == len||(winnerCount !=0 && winnerCount == successCounter)) {
                    return currentPlayer;
                }
            }
            lastPlayer = currentPlayer;
        }
        return null;
    }
}