package inventory.control.api.controller;

import inventory.control.api.dto.request.StoreRequest;
import inventory.control.api.dto.response.StoreResponse;
import inventory.control.api.mapper.StoreMapper;
import inventory.control.domain.model.StoreModel;
import inventory.control.domain.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/stores")
@AllArgsConstructor
@Validated
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    public ResponseEntity<StoreResponse> save(@Valid @RequestBody StoreRequest storeRequest) {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponse(storeService.save(StoreMapper.toModel(storeRequest))));
    }

    @GetMapping("/{storeCod}")
    public ResponseEntity<StoreResponse> findById(@PathVariable String storeCod) {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponse(storeService.findById(UUID.fromString(storeCod))));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<StoreModel>> findAll(Pageable pageable,
                                             @RequestParam(name = "zipCode", required = false) String zipCode,
                                             @RequestParam(name = "address", required = false) String address,
                                             @RequestParam(name = "district", required = false) String district) {
        return ResponseEntity.ok().body(storeService.findAll(pageable, zipCode, address, district));
    }

    @PutMapping("/{storeCod}")
    public ResponseEntity<StoreResponse> update(@PathVariable String storeCod, @RequestBody StoreRequest storeRequest) {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponse(storeService.update(StoreMapper.toModel(storeRequest), UUID.fromString(storeCod))));
    }

    @DeleteMapping("/{storeCod}")
    public ResponseEntity<UUID> delete(@PathVariable String storeCod) {
        return ResponseEntity.ok()
                .body(storeService.delete(UUID.fromString(storeCod)));
    }

}
