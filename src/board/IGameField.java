package board;

import exception.GameNotSetStepException;
import game.Step;

/**
 * Created by admin on 16.10.2016.
 */
public interface IGameField {
    public int getN();
    public void setStep(Step step) throws GameNotSetStepException;
    public int getValue(int x, int y);
    public boolean isFileldFilled();
    public int getFileld();
}
