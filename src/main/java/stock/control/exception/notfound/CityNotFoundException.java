package stock.control.exception.notfound;

public class CityNotFoundException extends RuntimeException {

    public CityNotFoundException() {
        super("Conflito: Cidade não encontrada na base de dados!");
    }

}
