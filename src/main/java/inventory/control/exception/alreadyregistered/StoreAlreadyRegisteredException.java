package inventory.control.domain.exception.alreadyregistered;

public class StoreAlreadyRegisteredException extends RuntimeException {

    public StoreAlreadyRegisteredException(String message) {
        super(message);
    }

}
