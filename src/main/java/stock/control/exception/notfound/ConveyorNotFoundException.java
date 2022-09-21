package stock.control.exception.notfound;

public class ConveyorNotFoundException extends RuntimeException {

    public ConveyorNotFoundException() {
        super("Conflito: Transportadora não encontrada na base de dados!");
    }

}
