package stock.control.domain.repository;

import stock.control.domain.model.ExitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ExitRepository extends JpaRepository<ExitModel, UUID> { }