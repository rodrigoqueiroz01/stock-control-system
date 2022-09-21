package stock.control.exception.notfound;

public class StoreNotFoundException extends RuntimeException {

    public StoreNotFoundException() {
        super("Conflito: Loja não encontrada na base de dados!");
    }

}
