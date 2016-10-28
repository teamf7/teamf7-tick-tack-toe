package test;

import exception.GameException;
import game.DisplayElement;
import game.IGame;
import game.Step;
import game.TwoPlayersGame;
import games.TicTacToe;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by admin on 16.10.2016.
 */
public class TicTacToeTest {
    IGame twoPlayersGame;
    public TicTacToeTest(){
        twoPlayersGame = new TicTacToe();
    }

    @Test
    public void createTwoGame() throws GameException{
        System.out.println("Create two game");

        twoPlayersGame.start();
        twoPlayersGame.makeStep(new Step(0,2));
        twoPlayersGame.makeStep(new Step(0,1));
        twoPlayersGame.makeStep(new Step(0,0));
        twoPlayersGame.makeStep(new Step(1,0));
        twoPlayersGame.makeStep(new Step(1,1));
        twoPlayersGame.makeStep(new Step(1,2));
        twoPlayersGame.makeStep(new Step(2,0));
        ((DisplayElement)twoPlayersGame).print();
        System.out.println("-------------------------");
        twoPlayersGame.makeStep(new Step(0,2));

    }
    @Test
    public void getCurrentActivePlayer() throws GameException {
        twoPlayersGame.start();
        twoPlayersGame.makeStep(new Step(0,1));
        ((DisplayElement)twoPlayersGame).print();
        int player1= twoPlayersGame.getCurrentActivePlayer();
        assertTrue(player1 == 1);
    }
    @Test
    public void getPrevPlayer() throws GameException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        int prevPlayer = ticTacToe.getPrevPlayer();
        assertTrue(1 == prevPlayer);
    }
    @Test
    public void isFileldFilled() throws GameException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        assertFalse(ticTacToe.isFileldFilled());
    }
    @Test
    public void undoStep() throws GameException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        assertTrue(ticTacToe.undoStep(1));
        assertTrue(ticTacToe.undoStep(1));
        assertFalse(ticTacToe.undoStep(1));
    }
    @Test(expected = GameException.class)
    public void makeStepError() throws GameException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        ticTacToe.makeStep(new Step(2,2));
        ticTacToe.makeStep(new Step(2,2));
    }

}
