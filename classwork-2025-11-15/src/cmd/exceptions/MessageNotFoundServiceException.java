package cmd.exceptions;

public class MessageNotFoundServiceException extends NotFoundServiceException {

    public MessageNotFoundServiceException() {
        super("User not found service exception!");
    }

}
