package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.CategoryAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.CategoryNotFoundException;
import inventory.control.domain.model.CategoryModel;
import inventory.control.domain.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryModel save(CategoryModel categoryModel) {
        if (!Objects.isNull(categoryRepository.findByName(categoryModel.getName()))) {
            throw new CategoryAlreadyRegisteredException("Já existe categoria com esse nome!");
        } else {
            return categoryRepository.save(categoryModel);
        }
    }

    public CategoryModel findById(UUID id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada!"));
    }

    public List<CategoryModel> findAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel update(CategoryModel categoryModel, UUID id) {
        categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada!"));
        categoryModel.setId(id);

        if (!Objects.isNull(categoryRepository.findByName(categoryModel.getName()))) {
            throw new CategoryAlreadyRegisteredException("Já existe categoria com esse nome!");
        }

        categoryRepository.save(categoryModel);
        return categoryModel;
    }

    public UUID delete(UUID id) {
        var category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Categoria não encontrada!"));
        categoryRepository.delete(category);
        return id;
    }

}
