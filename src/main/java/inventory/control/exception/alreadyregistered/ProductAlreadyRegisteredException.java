package inventory.control.domain.exception.alreadyregistered;

public class ProductAlreadyRegisteredException extends RuntimeException {

    public ProductAlreadyRegisteredException(String message) {
        super(message);
    }

}
