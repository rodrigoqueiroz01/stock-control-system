package inventory.control.domain.exception.alreadyregistered;

public class CategoryAlreadyRegisteredException extends RuntimeException {

    public CategoryAlreadyRegisteredException(String message) {
        super(message);
    }

}
