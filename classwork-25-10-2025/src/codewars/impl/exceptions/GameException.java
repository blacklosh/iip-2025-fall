package codewars.impl.exceptions;

public class GameException extends RuntimeException {

    private String message;

    public GameException(String message) {
        super(message);
    }
}
