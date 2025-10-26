package codewars.impl.exceptions;

public class NotEnoughTargetsException extends GameException {
    public NotEnoughTargetsException(String message) {
        super(message);
    }

    public NotEnoughTargetsException() {
        super("Собраны не все цели!");
    }
}
