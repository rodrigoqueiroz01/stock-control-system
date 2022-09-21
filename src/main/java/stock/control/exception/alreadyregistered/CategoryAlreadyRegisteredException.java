package stock.control.exception.alreadyregistered;

public class CategoryAlreadyRegisteredException extends RuntimeException {

    public CategoryAlreadyRegisteredException() {
        super("Conflito: Já existe categoria com esse nome na base de dados!");
    }

}
