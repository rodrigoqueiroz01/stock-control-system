package inventory.control.domain.exception.notfound;

public class ProhibitedNotFoundException extends RuntimeException {

    public ProhibitedNotFoundException(String message) {
        super(message);
    }

}
