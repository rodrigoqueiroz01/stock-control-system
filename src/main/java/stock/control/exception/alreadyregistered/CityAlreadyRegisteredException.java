package stock.control.exception.alreadyregistered;

public class CityAlreadyRegisteredException extends RuntimeException {

    public CityAlreadyRegisteredException() {
        super("Conflito: Cidade já cadastrada na base de dados!");
    }

}
