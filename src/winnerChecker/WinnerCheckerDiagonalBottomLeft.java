package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 17.10.2016.
 */
public class WinnerCheckerDiagonalBottomLeft implements WinnerCheckerInterface {
    private GameField gameField;
    private int winnerCount;

    public WinnerCheckerDiagonalBottomLeft(GameField gameField, int winnerCount) {
        this.gameField = gameField;
        this.winnerCount = winnerCount;
    }


    @Override
    public int checkWinner() {
        int currentPlayer;
        int lastPlayer = 0;
        int x,y;
        for(int k = 1; k < gameField.getN(); k++) {
            x = gameField.getN()-1;
            y = k;
            lastPlayer = 0;
            int successCounter = 1;
            while (y < gameField.getN()){
                currentPlayer = gameField.getValue(x, y);
                if (currentPlayer == lastPlayer && (currentPlayer != 0 && lastPlayer != 0)) {
                    successCounter++;
                    if (winnerCount == successCounter) {
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
                x--;
                y++;
            }
        } return 0;
    }

}
