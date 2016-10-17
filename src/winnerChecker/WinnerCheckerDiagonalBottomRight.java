package winnerChecker;

import board.GameField;
import game.Game;
import game.Player;

/**
 * Created by designAi on 17.10.2016.
 */
public class WinnerCheckerDiagonalBottomRight implements  WinnerCheckerInterface {
    private GameField gameField;
    private int winnerCount;
    public WinnerCheckerDiagonalBottomRight(GameField gameField,int winnerCount){
        this.gameField = gameField;
        this.winnerCount = winnerCount;
    };

    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer = null;
        for(int k = gameField.getN()-1; k > 0; k--){
            lastPlayer = null;
            int successCounter = 1;
            for (int i = 0; i < gameField.getN()-k; i++){
                currentPlayer = gameField.getValue(i,i+k);
                if (currentPlayer == lastPlayer && (currentPlayer != null && lastPlayer != null)) {
                    successCounter++;
                    if (winnerCount == successCounter) {
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
            }
        }
        return null;
    }

}
