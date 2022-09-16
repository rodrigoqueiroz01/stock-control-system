package inventory.control.domain.exception.notfound;

public class ProviderNotFoundException extends RuntimeException {

    public ProviderNotFoundException(String message) {
        super(message);
    }

}
