package inventory.control.api.controller;

import inventory.control.api.dto.request.ProductRequest;
import inventory.control.api.dto.response.ProductResponse;
import inventory.control.api.mapper.ProductMapper;
import inventory.control.domain.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Validated
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> save(@Valid @RequestBody ProductRequest productRequest) {
        return ResponseEntity
                .ok()
                .body(ProductMapper.toResponse(productService.save(ProductMapper.toModel(productRequest))));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable String productId) {
        return ResponseEntity
                .ok()
                .body(ProductMapper.toResponse(productService.findById(UUID.fromString(productId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(ProductMapper.toResponseList(productService.findAll()));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> update(@PathVariable String productId, @RequestBody ProductRequest productRequest) {
        return ResponseEntity
                .ok()
                .body(ProductMapper.toResponse(productService.update(ProductMapper.toModel(productRequest), UUID.fromString(productId))));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<UUID> delete(@PathVariable String productId) {
        return ResponseEntity
                .ok()
                .body(productService.delete(UUID.fromString(productId)));
    }

}
