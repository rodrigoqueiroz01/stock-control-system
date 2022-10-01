package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.OutpuItemRequest;
import stock.control.api.dto.response.OutputItemResponse;
import stock.control.api.dto.mapper.OutputItemMapper;
import stock.control.domain.service.OutputItemService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/outputItems")
@AllArgsConstructor
@Validated
public class OutputItemController {

    private final OutputItemService outputItemService;

    @PostMapping
    public ResponseEntity<OutputItemResponse> save(@Valid @RequestBody OutpuItemRequest outpuItemRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(OutputItemMapper.toResponse(outputItemService.save(OutputItemMapper.toModel(outpuItemRequest))));
    }

    @GetMapping("/{outputItemId}")
    public ResponseEntity<OutputItemResponse> findById(@PathVariable String outputItemId) {
        return ResponseEntity.ok().body(OutputItemMapper.toResponse(outputItemService.findById(UUID.fromString(outputItemId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OutputItemResponse>> findAll() {
        return ResponseEntity.ok().body(OutputItemMapper.toResponseList(outputItemService.findAll()));
    }

    @PutMapping("/{outputItemId}")
    public ResponseEntity<OutputItemResponse> update(@Valid @RequestBody OutpuItemRequest outpuItemRequest,
                                                     @PathVariable String outputItemId) {
        return ResponseEntity.ok()
                .body(OutputItemMapper.toResponse(outputItemService.update(OutputItemMapper.toModel(outpuItemRequest),
                        UUID.fromString(outputItemId))));
    }

    @DeleteMapping("/{outputItemId}")
    public ResponseEntity<Object> delete(@PathVariable String outputItemId) {
        String code = String.valueOf(outputItemService.delete(UUID.fromString(outputItemId)));

        return ResponseEntity.ok().body("Ítem de saída de código " + code + " deletado!");
    }

}
