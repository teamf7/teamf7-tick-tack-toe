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
    public int checkWinner() {
        int currentPlayer;
        int lastPlayer = 0;
        for(int k = gameField.getN()-1; k > 0; k--){
            lastPlayer = 0;
            int successCounter = 1;
            for (int i = 0; i < gameField.getN()-k; i++){
                currentPlayer = gameField.getValue(i,i+k);
                if (currentPlayer == lastPlayer && (currentPlayer != 0 && lastPlayer != 0)) {
                    successCounter++;
                    if (winnerCount == successCounter) {
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
            }
        }
        return 0;
    }

}
