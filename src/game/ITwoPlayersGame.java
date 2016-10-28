package game;

import exception.GameOverException;

/**
 * Created by designAi on 28.10.2016.
 */
public interface ITwoPlayersGame {
    public void resetPlayers() throws GameOverException;
    public void switchPlayers() throws GameOverException;

}
