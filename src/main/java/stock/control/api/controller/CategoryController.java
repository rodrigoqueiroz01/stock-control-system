package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.CategoryRequest;
import stock.control.api.dto.response.CategoryResponse;
import stock.control.api.mapper.CategoryMapper;
import stock.control.domain.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/categories")
@AllArgsConstructor
@Validated
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CategoryRequest categoryRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CategoryMapper.toResponse(categoryService.save(CategoryMapper.toModel(categoryRequest))));
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable String categoryId) {
        return ResponseEntity.ok().body(CategoryMapper.toResponse(categoryService.findById(UUID.fromString(categoryId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryResponse>> findAll() {
        return ResponseEntity.ok().body(CategoryMapper.toResponseList(categoryService.findAll()));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryResponse> update(@Valid @RequestBody CategoryRequest categoryRequest, @PathVariable String categoryId) {
        return ResponseEntity.ok()
                .body(CategoryMapper.toResponse(categoryService.update(CategoryMapper.toModel(categoryRequest),
                        UUID.fromString(categoryId))));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Object> delete(@PathVariable String categoryId) {
        String code = String.valueOf(categoryService.delete(UUID.fromString(categoryId)));

        return ResponseEntity.ok().body("Categoria de código " + code + " deletada!");
    }

}
