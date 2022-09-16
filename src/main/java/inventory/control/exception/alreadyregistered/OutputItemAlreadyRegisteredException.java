package inventory.control.domain.exception.alreadyregistered;

public class OutputItemAlreadyRegisteredException extends RuntimeException {

    public OutputItemAlreadyRegisteredException(String message) {
        super(message);
    }

}
