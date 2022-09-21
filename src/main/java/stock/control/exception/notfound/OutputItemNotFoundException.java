package stock.control.exception.notfound;

public class OutputItemNotFoundException extends RuntimeException {

    public OutputItemNotFoundException() {
        super("Conflito: Item de saída não encontrado na base de dados!");
    }

}
