package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import stock.control.domain.model.ProductModel;
import stock.control.domain.repository.ProductRepository;
import stock.control.exception.DataAlreadyRegisteredException;
import stock.control.exception.DataNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public ProductModel save(ProductModel productModel) {
        if (!Objects.isNull(productRepository.findByDescription(productModel.getDescription()))) {
            throw new DataAlreadyRegisteredException("Conflito: Produto já cadastrado na base de dados!");
        }

        return productRepository.save(productModel);
    }

    public ProductModel findById(UUID id) {
        return productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Produto não encontrado na base de dados!"));
    }

    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    public ProductModel update(ProductModel productModel, UUID id) {
        productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Produto não encontrado na base de dados!"));
        productModel.setId(id);

        if (!Objects.isNull(productRepository.findByDescription(productModel.getDescription()))) {
            throw new DataAlreadyRegisteredException("Conflito: Produto já cadastrado na base de dados!");
        }

        return productRepository.save(productModel);
    }

    public UUID delete(UUID id) {
        ProductModel product = productRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Produto não encontrado na base de dados!"));
        productRepository.delete(product);

        return id;
    }

}
