package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.StoreRequest;
import stock.control.api.dto.response.StoreResponse;
import stock.control.api.dto.mapper.StoreMapper;
import stock.control.domain.model.StoreModel;
import stock.control.domain.service.StoreService;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(StoreMapper.toResponse(storeService.save(StoreMapper.toModel(storeRequest))));
    }

    @GetMapping("/{storeCod}")
    public ResponseEntity<StoreResponse> findById(@PathVariable String storeCod) {
        return ResponseEntity.ok().body(StoreMapper.toResponse(storeService.findById(UUID.fromString(storeCod))));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<StoreModel>> findAll(Pageable pageable,
                                                    @RequestParam(name = "zipCode", required = false) String zipCode,
                                                    @RequestParam(name = "address", required = false) String address,
                                                    @RequestParam(name = "district", required = false) String district) {
        return ResponseEntity.ok().body(storeService.findAll(pageable, zipCode, address, district));
    }

    @PutMapping("/{storeCod}")
    public ResponseEntity<StoreResponse> update(@Valid @RequestBody StoreRequest storeRequest, @PathVariable String storeCod) {
        return ResponseEntity.ok()
                .body(StoreMapper.toResponse(storeService.update(StoreMapper.toModel(storeRequest), UUID.fromString(storeCod))));
    }

    @DeleteMapping("/{storeCod}")
    public ResponseEntity<Object> delete(@PathVariable String storeCod) {
        String code = String.valueOf(storeService.delete(UUID.fromString(storeCod)));

        return ResponseEntity.ok().body("Loja de código " + code + " deletada!");
    }

}
