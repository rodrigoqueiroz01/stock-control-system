package inventory.control.domain.repository;

import inventory.control.domain.model.ExitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ExitRepository extends JpaRepository<ExitModel, UUID> { }