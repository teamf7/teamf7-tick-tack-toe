package winnerChecker;

import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerHorizontal implements WinnerCheckerInterface{
    private GameField gameField;
    private int n =0;

    public WinnerCheckerHorizontal(GameField gameField) {
        this.gameField = gameField;
    }
    public WinnerCheckerHorizontal(GameField gameField, int n) {
        this.gameField = gameField;
        this.n = n;
    }
    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer =null;
        for(int i = 0, len = gameField.getN(); i < len; i++){
            lastPlayer =null;
            int successCounter = 1;
            for (int j = 0, len2 = gameField.getN(); j<len2; j++){
                currentPlayer = gameField.getValue(i,j);
                if(currentPlayer == lastPlayer && (currentPlayer !=null && lastPlayer !=null)){
                    successCounter++;
                    if(successCounter == len2||(n!=0 && n == successCounter)){
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
            }
        }
        return null;
    }
}