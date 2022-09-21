package stock.control.domain.repository;

import stock.control.domain.model.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.UUID;

public interface StoreRepository extends JpaRepository<StoreModel, UUID>, JpaSpecificationExecutor {

    StoreModel findByName(String name);

}
