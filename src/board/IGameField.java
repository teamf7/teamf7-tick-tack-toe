package board;

import exception.GameNotSetValueException;
import game.Player;
import game.Step;

/**
 * Created by admin on 16.10.2016.
 */
public interface IGameField {
    public int getN();
    public void setValue(Step step) throws GameNotSetValueException;
    public Player getValue(int x, int y);
    public boolean isFileldFilled();
    public int getFileld();
}
