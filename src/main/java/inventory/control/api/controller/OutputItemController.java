package inventory.control.api.controller;

import inventory.control.api.dto.request.OutpuItemRequest;
import inventory.control.api.dto.response.OutputItemResponse;
import inventory.control.api.mapper.OutputItemMapper;
import inventory.control.domain.service.OutputItemService;
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
        return ResponseEntity
                .ok()
                .body(OutputItemMapper.toResponse(outputItemService.save(OutputItemMapper.toModel(outpuItemRequest))));
    }

    @GetMapping("/{outputItemId}")
    public ResponseEntity<OutputItemResponse> findById(@PathVariable String outputItemId) {
        return ResponseEntity
                .ok()
                .body(OutputItemMapper.toResponse(outputItemService.findById(UUID.fromString(outputItemId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<OutputItemResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(OutputItemMapper.toResponseList(outputItemService.findAll()));
    }

    @PutMapping("/{outputItemId}")
    public ResponseEntity<OutputItemResponse> update(@PathVariable String outputItemId, @RequestBody OutpuItemRequest outpuItemRequest) {
        return ResponseEntity
                .ok()
                .body(OutputItemMapper.toResponse(outputItemService.update(OutputItemMapper.toModel(outpuItemRequest), UUID.fromString(outputItemId))));
    }

    @DeleteMapping("/{outputItemId}")
    public ResponseEntity<UUID> delete(@PathVariable String outputItemId) {
        return ResponseEntity
                .ok()
                .body(outputItemService.delete(UUID.fromString(outputItemId)));
    }

}
