package stock.control.exception.notfound;

public class EntryItemNotFoundException extends RuntimeException {

    public EntryItemNotFoundException() {
        super("Conflito: Item de entrada não encontrado na base de dados!");
    }
}
