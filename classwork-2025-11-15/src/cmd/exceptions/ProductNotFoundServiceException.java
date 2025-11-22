package cmd.exceptions;

public class ProductNotFoundServiceException extends NotFoundServiceException {

    public ProductNotFoundServiceException() {
        super("Product not found service exception!");
    }

}
