package inventory.control.domain.exception.alreadyregistered;

public class EntryItemAlreadyRegisteredException extends RuntimeException {

    public EntryItemAlreadyRegisteredException(String message) {
        super(message);
    }
}
