package cmd.exceptions;

import java.util.Random;

public class ServiceOperations {

    public void processOperation() {
        Random random = new Random();

        int n = random.nextInt(10);

        switch (n) {
            case 0:
                throw new ServiceException();
            case 1:
                throw new NotFoundServiceException();
            case 2:
                throw new ForbiddenServiceException();
            case 3:
                throw new UserNotFoundServiceException();
            case 4:
                throw new MessageNotFoundServiceException();
            case 5:
                throw new ProductNotFoundServiceException();
            case 6:
                throw new NotAdminForbiddenServiceException();
            default:
                break;
        }
    }

}
