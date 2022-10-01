package stock.control.domain.repository;

import stock.control.domain.model.ConveyorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ConveyorRepository extends JpaRepository<ConveyorModel, UUID>, JpaSpecificationExecutor {

    ConveyorModel findByConveyor(String nameConveyor);

}
