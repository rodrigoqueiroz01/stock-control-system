package stock.control.exception.alreadyregistered;

public class StoreAlreadyRegisteredException extends RuntimeException {

    public StoreAlreadyRegisteredException() {
        super("Conflito: Já existe loja com esse nome na base de dados!");
    }

}
