package stock.control.domain.service;

import stock.control.exception.alreadyregistered.CityAlreadyRegisteredException;
import stock.control.exception.notfound.CityNotFoundException;
import stock.control.domain.model.CityModel;
import stock.control.domain.repository.CityRepository;
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
            throw new CityAlreadyRegisteredException();
        }

        return cityRepository.save(cityModel);
    }

    public CityModel findById(UUID id) {
        return cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException());
    }

    public List<CityModel> findAll() {
        return cityRepository.findAll();
    }

    public CityModel update(CityModel cityModel, UUID id) {
        cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException());
        cityModel.setId(id);

        if (!Objects.isNull(cityRepository.findByCity(cityModel.getCity()))) {
            throw new CityAlreadyRegisteredException();
        }

        return cityRepository.save(cityModel);
    }

    public UUID delete(UUID id) {
        CityModel city = cityRepository.findById(id).orElseThrow(() -> new CityNotFoundException());
        cityRepository.delete(city);

        return id;
    }

}
