package inventory.control.domain.exception.alreadyregistered;

public class CityAlreadyRegisteredException extends RuntimeException {

    public CityAlreadyRegisteredException(String message) {
        super(message);
    }

}
