package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.EntryItemRequest;
import stock.control.api.dto.response.EntryItemResponse;
import stock.control.api.mapper.EntryItemMapper;
import stock.control.domain.model.EntryItemModel;
import stock.control.domain.service.EntryItemService;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(EntryItemMapper.toResponse(entryItemService.save(EntryItemMapper.toModel(entryItemRequest))));
    }

    @GetMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> findById(@PathVariable String entryItemId) {
        return ResponseEntity.ok().body(EntryItemMapper.toResponse(entryItemService.findById(UUID.fromString(entryItemId))));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<EntryItemModel>> findAll(Pageable pageable,
                                                        @RequestParam(name = "batch", required = false) String batch) {
        return ResponseEntity.ok().body(entryItemService.findAll(pageable, batch));
    }

    @PutMapping("/{entryItemId}")
    public ResponseEntity<EntryItemResponse> update(@Valid @RequestBody EntryItemRequest entryItemRequest,
                                                    @PathVariable String entryItemId) {
        return ResponseEntity.ok()
                .body(EntryItemMapper.toResponse(entryItemService.update(EntryItemMapper.toModel(entryItemRequest),
                        UUID.fromString(entryItemId))));
    }

    @DeleteMapping("/{entryItemId}")
    public ResponseEntity<Object> delete(@PathVariable String entryItemId) {
        String code = String.valueOf(entryItemService.delete(UUID.fromString(entryItemId)));

        return ResponseEntity.ok().body("Item de entrada de código " + code + " deletado!");
    }

}
