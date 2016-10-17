package games;

import exception.GameException;
import game.Player;
import game.Step;
import game.TwoPlayersGame;

/**
 * Created by designAi on 16.10.2016.
 */
public class TicTacToe extends TwoPlayersGame{

    public TicTacToe() {
        super(3);
    }


    @Override
    public void getWinner() throws GameException {
        Player player = checkWinner();
        if(player != null){
            gameOver("Игру выйграл "+player.getName());
        }
        if(isFileldFilled()){
            gameOver("Ничья");
        }
    }

    public void gameOver(String gameOver){
        System.out.println(gameOver);
    }
}
