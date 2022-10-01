package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import stock.control.domain.model.CityModel;
import stock.control.domain.repository.CityRepository;
import stock.control.exception.DataAlreadyRegisteredException;
import stock.control.exception.DataNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public CityModel save(CityModel cityModel) {
        if (!Objects.isNull(cityRepository.findByCity(cityModel.getName()))) {
            throw new DataAlreadyRegisteredException("Conflito: Cidade já cadastrada na base de dados!");
        }

        return cityRepository.save(cityModel);
    }

    public CityModel findById(UUID id) {
        return cityRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Cidade não encontrada na base de dados!"));
    }

    public List<CityModel> findAll() {
        return cityRepository.findAll();
    }

    public CityModel update(CityModel cityModel, UUID id) {
        cityRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Cidade não encontrada na base de dados!"));
        cityModel.setId(id);

        if (!Objects.isNull(cityRepository.findByCity(cityModel.getName()))) {
            throw new DataAlreadyRegisteredException("Conflito: Cidade já cadastrada na base de dados!");
        }

        return cityRepository.save(cityModel);
    }

    public UUID delete(UUID id) {
        CityModel city = cityRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Cidade não encontrada na base de dados!"));
        cityRepository.delete(city);

        return id;
    }

}
