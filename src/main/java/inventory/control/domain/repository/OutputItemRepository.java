package inventory.control.domain.repository;

import inventory.control.domain.model.OutputItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface OutputItemRepository extends JpaRepository<OutputItemModel, UUID> { }
