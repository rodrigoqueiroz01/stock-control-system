package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.CityAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.CityNotFoundException;
import inventory.control.domain.model.CityModel;
import inventory.control.domain.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CityService {

    private final CityRepository cityRepository;

    public CityModel save(CityModel cityModel) {
        if (!Objects.isNull(cityRepository.findByCity(cityModel.getCity()))) {
            throw new CityAlreadyRegisteredException("Cidade já cadastrada no sistema!");
        } else {
            return cityRepository.save(cityModel);
        }
    }

    public CityModel findById(UUID id) {
        return cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("Cidade não encontrada!"));
    }

    public List<CityModel> findAll() {
        return cityRepository.findAll();
    }

    public CityModel update(CityModel cityModel, UUID id) {
        cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("Cidade não encontrada!"));
        cityModel.setId(id);

        if (!Objects.isNull(cityRepository.findByCity(cityModel.getCity()))) {
            throw new CityAlreadyRegisteredException("Cidade já cadastrada no sistema!");
        } else {
            cityRepository.save(cityModel);
            return cityModel;
        }
    }

    public UUID delete(UUID id) {
        var city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException("Cidade não encontrada!"));
        cityRepository.delete(city);
        return id;
    }

}
