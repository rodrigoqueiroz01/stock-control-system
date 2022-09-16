package inventory.control.domain.exception.alreadyregistered;

public class UserAlreadyRegisteredException extends RuntimeException {

    public UserAlreadyRegisteredException(String message) {
        super(message);
    }

}
