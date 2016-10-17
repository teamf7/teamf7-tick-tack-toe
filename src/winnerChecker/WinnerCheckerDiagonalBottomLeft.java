package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 17.10.2016.
 */
public class WinnerCheckerDiagonalBottomLeft implements WinnerCheckerInterface {
    private GameField gameField;
    private int n;

    public WinnerCheckerDiagonalBottomLeft(GameField gameField, int n) {
        this.gameField = gameField;
        this.n = n;
    }


    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer = null;
        int x,y;
        for(int k = 1; k < gameField.getN(); k++) {
            x = gameField.getN()-1;
            y = k;
            lastPlayer = null;
            int successCounter = 1;
            while (y < gameField.getN()){
                currentPlayer = gameField.getValue(x, y);
                if (currentPlayer == lastPlayer && (currentPlayer != null && lastPlayer != null)) {
                    successCounter++;
                    if (n == successCounter) {
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
                x--;
                y++;
            }
        } return null;
    }

}
