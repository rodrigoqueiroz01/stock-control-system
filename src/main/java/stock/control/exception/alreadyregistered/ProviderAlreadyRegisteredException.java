package stock.control.exception.alreadyregistered;

public class ProviderAlreadyRegisteredException extends RuntimeException {

    public ProviderAlreadyRegisteredException() {
        super("Conflito: Esse fornecedor já existe na base de dados!");
    }

}
