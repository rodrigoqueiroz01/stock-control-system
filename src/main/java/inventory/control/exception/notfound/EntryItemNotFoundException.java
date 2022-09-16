package inventory.control.domain.exception.notfound;

public class EntryItemNotFoundException extends RuntimeException {

    public EntryItemNotFoundException(String message) {
        super(message);
    }
}
