package inventory.control.domain.exception.notfound;

public class StoreNotFoundException extends RuntimeException {

    public StoreNotFoundException(String message) {
        super(message);
    }

}
