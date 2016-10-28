package exception;

/**
 * Created by admin on 16.10.2016.
 */
public class GameNotSetStepException extends GameException{
    public GameNotSetStepException() {
        super("Поле занято");
    }
}
