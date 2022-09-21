package stock.control.domain.repository;

import stock.control.domain.model.CityModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CityRepository extends JpaRepository<CityModel, UUID> {

    CityModel findByCity(String nameCity);

}
