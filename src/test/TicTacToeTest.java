package test;

import exception.GameException;
import exception.GameOverException;
import exception.GameUndoStepException;
import game.*;
import games.TicTacToe;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by admin on 16.10.2016.
 */
public class TicTacToeTest {
    IGame game;
    public TicTacToeTest(){
        game = new TicTacToe();
    }

    @Test(expected = GameOverException.class)
    public void createGameAndMakeErrorStepTest() throws GameException{
        System.out.println("Create game");

        game.start();
        game.makeStep(new Step(0,2));
        game.makeStep(new Step(0,1));
        game.makeStep(new Step(0,0));
        game.makeStep(new Step(1,0));
        game.makeStep(new Step(1,1));
        game.makeStep(new Step(1,2));
        game.makeStep(new Step(2,0));
        ((DisplayElement) game).print();
        System.out.println("-------------------------");
        game.makeStep(new Step(0,2));

    }
    @Test
    public void getCurrentActivePlayerTest() throws GameException {
        game.start();
        game.makeStep(new Step(0,1));
        ((DisplayElement) game).print();
        int player1= ((ITwoPlayersGame) game).getCurrentActivePlayer();
        assertTrue(player1 == 1);
    }
    @Test
    public void getPrevPlayerTest() throws GameException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        int prevPlayer = ticTacToe.getPrevPlayer();
        assertTrue(1 == prevPlayer);
    }
    @Test
    public void isFileldFilledTest() throws GameException {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        assertFalse(ticTacToe.isFieldFilled());
    }
    @Test(expected = GameUndoStepException.class)
    public void undoStepTest() throws GameException {
        System.out.println("UndoStepTest");
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        assertTrue(ticTacToe.undoStep(1));
        assertTrue(ticTacToe.undoStep(1));
        assertFalse(ticTacToe.undoStep(1));
        System.out.println("End undoStep");
    }

    @Test(expected = GameException.class)
    public void makeStepErrorTest() throws GameException {
        System.out.println("makeStepErrorTest");
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,2));
        ticTacToe.makeStep(new Step(2,2));
        ticTacToe.makeStep(new Step(2,2));
    }
    @Test
    public void gameOverTest() throws GameException {
        System.out.println("gameOverTest - ничья");
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.start();
        ticTacToe.makeStep(new Step(0,0));
        ticTacToe.makeStep(new Step(0,1));
        ticTacToe.makeStep(new Step(0,2));
        ticTacToe.makeStep(new Step(1,1));
        ticTacToe.makeStep(new Step(1,0));
        ticTacToe.makeStep(new Step(1,2));
        ticTacToe.makeStep(new Step(2,1));
        ticTacToe.makeStep(new Step(2,0));
        ticTacToe.makeStep(new Step(2,2));
    }
}
