package inventory.control.domain.exception.alreadyregistered;

public class ProhibitedAlreadyRegisteredException extends RuntimeException {

    public ProhibitedAlreadyRegisteredException(String message) {
        super(message);
    }

}
