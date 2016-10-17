package test;

import exception.GameException;
import game.Step;
import game.TwoPlayersGame;
import games.TicTacToe;
import org.junit.Test;

/**
 * Created by admin on 16.10.2016.
 */
public class TicTacToeTest {
    TwoPlayersGame twoPlayersGame;
    public TicTacToeTest(){
        twoPlayersGame = new TicTacToe();
    }

    @Test
    public void createTwoGame() throws GameException{
        System.out.println("two game");
        twoPlayersGame.start();
        twoPlayersGame.makeStep(new Step(0,2));
        twoPlayersGame.makeStep(new Step(0,1));
        twoPlayersGame.makeStep(new Step(0,0));
        twoPlayersGame.makeStep(new Step(1,0));
        twoPlayersGame.makeStep(new Step(1,1));
        twoPlayersGame.makeStep(new Step(1,2));
        twoPlayersGame.makeStep(new Step(2,0));

        twoPlayersGame.print();
        System.out.println("-------------------------");
        twoPlayersGame.undoStep(twoPlayersGame.getHistory().size());
        twoPlayersGame.makeStep(new Step(1,2));
        twoPlayersGame.makeStep(new Step(2,0));
        twoPlayersGame.print();
    }
}
