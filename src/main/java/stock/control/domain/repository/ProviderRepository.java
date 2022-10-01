package stock.control.domain.repository;

import stock.control.domain.model.ProviderModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProviderRepository extends JpaRepository<ProviderModel, UUID>, JpaSpecificationExecutor {

    ProviderModel findByProvider(String provider);

    Page<ProviderModel> findAll(Object provider, Pageable pageable);
}
