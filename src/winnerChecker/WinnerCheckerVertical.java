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
    GameField board;
    int n = 0;

    public WinnerCheckerVertical(GameField gameField){
        this.board = gameField;
    }
    public WinnerCheckerVertical(GameField gameField,int n){
        this.board = gameField;
        this.n = n;
    }

    @Override
    public Player checkWinner() {
        Player currentPlayer;
        Player lastPlayer = null;
        for(int i = 0, len = board.getN(); i< len; i++){
            lastPlayer =null;
            int successCounter = 1;
            for (int j = 0, len2 = board.getN();j<len2; j++){
                currentPlayer = board.getValue(j, i);
                if(currentPlayer == lastPlayer && (currentPlayer !=null && lastPlayer !=null)){
                    successCounter++;
                    if(successCounter == len2||(n != 0&& n ==successCounter)){
                        return currentPlayer;
                    }
                }lastPlayer = currentPlayer;
            }
        }
        return null;
    }
}