package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerDiagonalLeft implements WinnerCheckerInterface {
    GameField gameField;
    int n;
    public WinnerCheckerDiagonalLeft(GameField gameField) {
        this.gameField = gameField;
    }
    public WinnerCheckerDiagonalLeft(GameField gameField, int n) {
        this.gameField = gameField;
        this.n = n;
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
                if (successCounter == len||(n!=0 && n == successCounter)) {
                    return currentPlayer;
                }
            }
            lastPlayer = currentPlayer;
        }
        return null;
    }
}