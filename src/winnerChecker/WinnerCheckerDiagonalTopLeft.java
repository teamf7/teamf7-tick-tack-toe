package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerDiagonalTopLeft implements WinnerCheckerInterface {
    GameField gameField;
    int n;

    public WinnerCheckerDiagonalTopLeft(GameField gameField, int n) {
        this.gameField = gameField;
        this.n = n;
    }



    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer = null;
        int x,y;
        for(int k = 0; k < gameField.getN(); k++){
            x = k;
            y = 0;
            lastPlayer = null;
            int successCounter = 1;
            while (x >= 0){
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
        }
      return null;
    }

}
