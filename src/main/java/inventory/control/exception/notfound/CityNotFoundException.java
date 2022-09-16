package inventory.control.domain.exception.notfound;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException(String message) {
        super(message);
    }

}
