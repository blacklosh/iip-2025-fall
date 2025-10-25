package codewars.impl.exceptions;

public class StoneInterruptedException extends GameException {

    public StoneInterruptedException(String message) {
        super(message);
    }

    public StoneInterruptedException() {
        super("Робот разрушен из-за столкновения");
    }
}
