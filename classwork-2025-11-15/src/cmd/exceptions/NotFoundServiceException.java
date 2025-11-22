package cmd.exceptions;

public class NotFoundServiceException extends ServiceException {

    public NotFoundServiceException() {
        super("Something not found in service");
    }

    protected NotFoundServiceException(String s) {
        super(s);
    }

}
