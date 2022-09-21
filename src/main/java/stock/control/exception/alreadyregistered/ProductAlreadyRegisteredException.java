package stock.control.exception.alreadyregistered;

public class ProductAlreadyRegisteredException extends RuntimeException {

    public ProductAlreadyRegisteredException() {
        super("Conflito: Esse produto já existe na base de dados!");
    }

}
