package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerDiagonalTopLeft implements WinnerCheckerInterface {
    private GameField gameField;
    private int winnerCount;

    public WinnerCheckerDiagonalTopLeft(GameField gameField, int winnerCount) {
        this.gameField = gameField;
        this.winnerCount = winnerCount;
    }



    @Override
    public int checkWinner() {
        int currentPlayer;
        int lastPlayer = 0;
        int x,y;
        for(int k = 0; k < gameField.getN(); k++){
            x = k;
            y = 0;
            lastPlayer = 0;
            int successCounter = 1;
            while (x >= 0){
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
        }
      return 0;
    }

}
