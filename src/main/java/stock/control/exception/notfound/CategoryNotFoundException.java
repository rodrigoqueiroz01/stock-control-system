package stock.control.exception.notfound;

public class CategoryNotFoundException extends RuntimeException {

    public CategoryNotFoundException() {
        super("Conflito: Categoria não encontrada na base de dados!");
    }

}
