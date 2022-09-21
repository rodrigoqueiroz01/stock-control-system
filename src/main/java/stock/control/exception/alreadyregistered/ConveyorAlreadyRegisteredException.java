package stock.control.exception.alreadyregistered;

public class ConveyorAlreadyRegisteredException extends RuntimeException {

    public ConveyorAlreadyRegisteredException() {
        super("Conflito: Transportadora já cadastrada na base de dados!");
    }

}
