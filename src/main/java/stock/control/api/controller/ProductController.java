package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.ProductRequest;
import stock.control.api.dto.response.ProductResponse;
import stock.control.api.mapper.ProductMapper;
import stock.control.domain.service.ProductService;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProductMapper.toResponse(productService.save(ProductMapper.toModel(productRequest))));
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> findById(@PathVariable String productId) {
        return ResponseEntity.ok().body(ProductMapper.toResponse(productService.findById(UUID.fromString(productId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok().body(ProductMapper.toResponseList(productService.findAll()));
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductResponse> update(@Valid @RequestBody ProductRequest productRequest, @PathVariable String productId) {
        return ResponseEntity.ok()
                .body(ProductMapper.toResponse(productService.update(ProductMapper.toModel(productRequest),
                        UUID.fromString(productId))));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Object> delete(@PathVariable String productId) {
        String code = String.valueOf(productService.delete(UUID.fromString(productId)));

        return ResponseEntity.ok().body("Produto de código " + code + " deletado!");
    }

}
