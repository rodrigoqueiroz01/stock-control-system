package inventory.control.domain.exception.notfound;

public class ExitNotFoundException extends RuntimeException {

    public ExitNotFoundException(String message) {
        super(message);
    }

}
