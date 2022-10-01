package stock.control.domain.repository;

import stock.control.domain.model.ProhibitedModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ProhibitedRepository extends JpaRepository<ProhibitedModel, UUID> { }
