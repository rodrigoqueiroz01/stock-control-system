package stock.control.domain.repository;

import stock.control.domain.model.EntryItemModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EntryItemRepository extends JpaRepository<EntryItemModel, UUID>, JpaSpecificationExecutor { }
