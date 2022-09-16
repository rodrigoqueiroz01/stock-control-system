package inventory.control.domain.repository;

import inventory.control.domain.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryModel, UUID> {

    CategoryModel findByName(String name);

}
