package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerHorizontal implements WinnerCheckerInterface{
    private GameField gameField;
    private int winnerCount = 0;

    public WinnerCheckerHorizontal(GameField gameField){
        this.gameField = gameField;
    }

    public WinnerCheckerHorizontal(GameField gameField, int winnerCount) {
        this.gameField = gameField;
        this.winnerCount = this.winnerCount;
    }
    @Override
    public int checkWinner() {
        int currentPlayer;
        int lastPlayer = 0;
        for(int i = 0, len = gameField.getN(); i < len; i++){
            lastPlayer = 0;
            int successCounter = 1;
            for (int j = 0, len2 = gameField.getN(); j<len2; j++){
                currentPlayer = gameField.getValue(i,j);
                if(currentPlayer == lastPlayer && (currentPlayer != 0 && lastPlayer != 0)){
                    successCounter++;
                    if(successCounter == len2||(winnerCount !=0 && winnerCount == successCounter)){
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
            }
        }
        return 0;
    }
}