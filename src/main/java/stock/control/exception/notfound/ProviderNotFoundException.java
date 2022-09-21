package stock.control.exception.notfound;

public class ProviderNotFoundException extends RuntimeException {

    public ProviderNotFoundException() {
        super("Conflito: Fornecedor não encontrado na base de dados!");
    }

}
