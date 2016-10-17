package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 17.10.2016.
 */
public class WinnerCheckerDiagonalTopRight implements WinnerCheckerInterface {
    private GameField gameField;
    private int n;

    public WinnerCheckerDiagonalTopRight(GameField gameField, int n) {
        this.gameField = gameField;
        this.n = n;
    }
    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer = null;
        for(int k = 0; k < gameField.getN(); k++){
            lastPlayer = null;
            int successCounter = 1;
            for (int i = 0; i < gameField.getN()-k; i++){
                currentPlayer = gameField.getValue(i,i+k);
                if (currentPlayer == lastPlayer && (currentPlayer != null && lastPlayer != null)) {
                    successCounter++;
                    if (n == successCounter) {
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
            }
        }return null;
    }
}
