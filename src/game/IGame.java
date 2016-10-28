package game;

import exception.GameException;
import exception.GameNotSetStepException;
import exception.GameOverException;
import exception.GameUndoStepException;

import java.util.List;

/**
 * Created by admin on 16.10.2016.
 */
public interface IGame {
    public void start() throws GameException;

    public boolean undoStep(int n) throws GameOverException, GameNotSetStepException, GameUndoStepException;

    public List getHistory();

    public boolean makeStep(Step step) throws GameException;


}