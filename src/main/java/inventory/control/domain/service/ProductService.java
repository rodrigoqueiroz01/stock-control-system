package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.ProductAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.ProductNotFoundException;
import inventory.control.domain.model.ProductModel;
import inventory.control.domain.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductModel save(ProductModel productModel) {
        if(!Objects.isNull(productRepository.findByDescription(productModel.getDescription()))) {
            throw new ProductAlreadyRegisteredException("Esse produto já existe no sistema!");
        } else {
            return productRepository.save(productModel);
        }
    }

    public ProductModel findById(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado!"));
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel update(ProductModel productModel, UUID id) {
        productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado!"));
        productModel.setId(id);

        if(!Objects.isNull(productRepository.findByDescription(productModel.getDescription()))) {
            throw new ProductAlreadyRegisteredException("Esse produto já existe no sistema!");
        } else {
            productRepository.save(productModel);
            return productModel;
        }
    }

    public UUID delete(UUID id) {
        var product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Produto não encontrado!"));
        productRepository.delete(product);
        return id;
    }

}
