package cmd.exceptions;

public class ForbiddenServiceException extends ServiceException {

    public ForbiddenServiceException() {
        super("Someone forbidden in service");
    }

    protected ForbiddenServiceException(String s) {
        super(s);
    }

}
