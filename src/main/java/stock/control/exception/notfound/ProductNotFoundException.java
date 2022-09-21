package stock.control.exception.notfound;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException() {
        super("Conflito: Produto não encontrado na base de dados!");
    }

}
