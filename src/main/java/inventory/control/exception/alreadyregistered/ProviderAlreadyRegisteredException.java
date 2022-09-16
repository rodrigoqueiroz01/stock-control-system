package inventory.control.domain.exception.alreadyregistered;

public class ProviderAlreadyRegisteredException extends RuntimeException {

    public ProviderAlreadyRegisteredException(String message) {
        super(message);
    }

}
