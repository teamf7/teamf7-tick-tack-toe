package game;

import exception.GameException;
import exception.GameOverException;

import java.util.List;

/**
 * Created by admin on 16.10.2016.
 */
public interface IGame {
    public void resetPlayers() throws GameOverException;

    public void start() throws GameException;

    public void switchPlayers() throws GameOverException;

    public boolean definePlayer(Player player);

    public void getWinner() throws GameException;

    public String gameOver(Player player);

    public String gameOver();

    public void initialization(int successFilled);

    public boolean undoStep(int n) throws GameOverException;

    public List getHistory();

    public Player getCurrentActivePlayer();

    public boolean makeStep(Step step) throws GameException;

    public Player checkWinner();

    public boolean isFileldFilled();

}