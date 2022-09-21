package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import stock.control.domain.model.CategoryModel;
import stock.control.domain.repository.CategoryRepository;
import stock.control.exception.alreadyregistered.CategoryAlreadyRegisteredException;
import stock.control.exception.notfound.CategoryNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryModel save(CategoryModel categoryModel) {
        if (!Objects.isNull(categoryRepository.findByName(categoryModel.getName()))) {
            throw new CategoryAlreadyRegisteredException();
        }

        return categoryRepository.save(categoryModel);
    }

    public CategoryModel findById(UUID id) {
        return categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
    }

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel update(CategoryModel categoryModel, UUID id) {
        categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
        categoryModel.setId(id);

        if (!Objects.isNull(categoryRepository.findByName(categoryModel.getName()))) {
            throw new CategoryAlreadyRegisteredException();
        }

        return categoryRepository.save(categoryModel);
    }

    public UUID delete(UUID id) {
        CategoryModel category = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException());
        categoryRepository.delete(category);

        return id;
    }

}
