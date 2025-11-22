package cmd.exceptions;

public class UserNotFoundServiceException extends NotFoundServiceException {

    public UserNotFoundServiceException() {
        super("User not found service exception!");
    }

}
