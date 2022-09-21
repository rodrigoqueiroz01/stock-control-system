package stock.control.exception.notfound;

public class ProhibitedNotFoundException extends RuntimeException {

    public ProhibitedNotFoundException() {
        super("Conflito: Entrada não encontrada na base de dados!");
    }

}
