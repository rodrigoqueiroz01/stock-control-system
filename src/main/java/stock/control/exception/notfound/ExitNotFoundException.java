package stock.control.exception.notfound;

public class ExitNotFoundException extends RuntimeException {

    public ExitNotFoundException() {
        super("Conflito: Saída não encontrada na base de dados!");
    }

}
