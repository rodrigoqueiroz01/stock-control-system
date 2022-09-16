package inventory.control.domain.exception.alreadyregistered;

public class ConveyorAlreadyRegisteredException extends RuntimeException {

    public ConveyorAlreadyRegisteredException(String message) {
        super(message);
    }

}
