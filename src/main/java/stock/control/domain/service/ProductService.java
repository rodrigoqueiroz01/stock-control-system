package stock.control.domain.service;

import stock.control.exception.alreadyregistered.ProductAlreadyRegisteredException;
import stock.control.exception.notfound.ProductNotFoundException;
import stock.control.domain.model.ProductModel;
import stock.control.domain.repository.ProductRepository;
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
        if (!Objects.isNull(productRepository.findByDescription(productModel.getDescription()))) {
            throw new ProductAlreadyRegisteredException();
        }

        return productRepository.save(productModel);
    }

    public ProductModel findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel update(ProductModel productModel, UUID id) {
        productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        productModel.setId(id);

        if (!Objects.isNull(productRepository.findByDescription(productModel.getDescription()))) {
            throw new ProductAlreadyRegisteredException();
        }

        return productRepository.save(productModel);
    }

    public UUID delete(UUID id) {
        ProductModel product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException());
        productRepository.delete(product);

        return id;
    }

}
