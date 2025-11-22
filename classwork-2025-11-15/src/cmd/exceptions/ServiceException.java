package cmd.exceptions;

public class ServiceException extends RuntimeException {

    public ServiceException() {
        super("Undefined service exception");
    }

    protected ServiceException(String msg) {
        super(msg);
    }

}
