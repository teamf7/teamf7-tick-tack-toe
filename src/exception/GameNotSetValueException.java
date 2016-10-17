package exception;

/**
 * Created by admin on 16.10.2016.
 */
public class GameNotSetValueException extends GameException{
    public GameNotSetValueException() {
        super("Поле занято");
    }
}
