package inventory.control.api.controller;

import inventory.control.api.dto.request.EntryItemRequest;
import inventory.control.api.dto.response.EntryItemResponse;
import inventory.control.api.mapper.EntryItemMapper;
import inventory.control.domain.model.EntryItemModel;
import inventory.control.domain.service.EntryItemService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/entryItems")
@AllArgsConstructor
@Validated
public class EntryItemController {

    private final EntryItemService entryItemService;

    @PostMapping
    public ResponseEntity<EntryItemResponse> save(@Valid @RequestBody EntryItemRequest entryItemRequest) {
        return ResponseEntity.ok()
                .body(EntryItemMapper.toResponse(entryItemService.save(EntryItemMapper.toModel(entryItemRequest))));
    }

    @GetMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> findById(@PathVariable String entryItemId) {
        return ResponseEntity
                .ok()
                .body(EntryItemMapper.toResponse(entryItemService.findById(UUID.fromString(entryItemId))));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<EntryItemModel>> findAll(Pageable pageable,
                                                        @RequestParam(name = "batch", required = false) String batch) {
        return ResponseEntity.ok().body(entryItemService.findAll(pageable, batch));
    }

    @PutMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> update(@PathVariable String entryItemId, @RequestBody EntryItemRequest entryItemRequest) {
        return ResponseEntity
                .ok()
                .body(EntryItemMapper.toResponse(entryItemService.update(EntryItemMapper.toModel(entryItemRequest), UUID.fromString(entryItemId))));
    }

    @DeleteMapping("/{entryItemId}")
    public ResponseEntity<UUID> delete(@PathVariable String entryItemId) {
        return ResponseEntity
                .ok()
                .body(entryItemService.delete(UUID.fromString(entryItemId)));
    }

}
