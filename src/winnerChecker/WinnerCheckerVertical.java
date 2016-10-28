package winnerChecker;

/**
 * Created by admin on 16.10.2016.
 */
import board.GameField;
import game.Player;

/**
 * Created by designAi on 15.10.2016.
 */
public class WinnerCheckerVertical implements WinnerCheckerInterface{
    private GameField board;
    private int winnerCount = 0;

    public WinnerCheckerVertical(GameField gameField){
        this.board = gameField;
    }
    public WinnerCheckerVertical(GameField gameField,int winnerCount){
        this.board = gameField;
        this.winnerCount = winnerCount;
    }

    @Override
    public int checkWinner() {
        int currentPlayer;
        int lastPlayer = 0;
        for(int i = 0, len = board.getN(); i< len; i++){
            lastPlayer = 0;
            int successCounter = 1;
            for (int j = 0, len2 = board.getN();j<len2; j++){
                currentPlayer = board.getValue(j, i);
                if(currentPlayer == lastPlayer && (currentPlayer != 0 && lastPlayer != 0)){
                    successCounter++;
                    if(successCounter == len2||(winnerCount != 0&& winnerCount ==successCounter)){
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
            }
        }
        return  0;
    }
}