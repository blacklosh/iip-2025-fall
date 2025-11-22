package cmd.exceptions;

public class NotAdminForbiddenServiceException extends ForbiddenServiceException {

    public NotAdminForbiddenServiceException() {
        super("User not allowed to admin part of service!");
    }

}
