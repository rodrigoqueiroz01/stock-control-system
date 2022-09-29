package stock.control.exception;

public class DataAlreadyRegisteredException extends RuntimeException {

    public DataAlreadyRegisteredException(String message) {
        super(message);
    }

}
