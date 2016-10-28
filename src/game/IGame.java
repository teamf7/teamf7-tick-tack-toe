package game;

import exception.GameException;
import exception.GameOverException;

import java.util.List;

/**
 * Created by admin on 16.10.2016.
 */
public interface IGame {
    public void start() throws GameException;

    public void getWinner() throws GameException;

    public void gameOver(int player);

    public String gameOver();

    public void initialization();

    public boolean undoStep(int n) throws GameOverException;

    public List getHistory();

    public int getCurrentActivePlayer();

    public boolean makeStep(Step step) throws GameException;

    public int checkWinner();

}