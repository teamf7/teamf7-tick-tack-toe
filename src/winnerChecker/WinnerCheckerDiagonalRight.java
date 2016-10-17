package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerDiagonalRight implements WinnerCheckerInterface {
    GameField board;
    int n = 0;
    public WinnerCheckerDiagonalRight(GameField gameField) {
        this.board = gameField;
    }
    public WinnerCheckerDiagonalRight(GameField gameField,int n) {
        this.board = gameField;
        this.n = n;
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
                if (successCounter == len ||(n != 0 && n == successCounter)) {
                    return currentPlayer;
                }
            }
            lastPlayer = currentPlayer;
        }
        return null;
    }
}