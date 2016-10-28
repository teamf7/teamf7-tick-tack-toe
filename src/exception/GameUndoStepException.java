package exception;

/**
 * Created by designAi on 29.10.2016.
 */
public class GameUndoStepException extends GameException{
    public GameUndoStepException(String message) {
        super(message);
    }
    public GameUndoStepException() {
        super("Нету шагов для отмены");
    }
}
