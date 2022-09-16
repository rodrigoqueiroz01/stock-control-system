package inventory.control.api.controller;

import inventory.control.api.dto.request.ConveyorRequest;
import inventory.control.api.dto.response.ConveyorResponse;
import inventory.control.api.mapper.ConveyorMapper;
import inventory.control.domain.model.ConveyorModel;
import inventory.control.domain.service.ConveyorService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/conveyors")
@AllArgsConstructor
@Validated
public class ConveyorController {

    private final ConveyorService conveyorService;

    @PostMapping
    public ResponseEntity<ConveyorResponse> save(@Valid @RequestBody ConveyorRequest conveyorRequest) {
        return ResponseEntity
                .ok()
                .body(ConveyorMapper.toResponse(conveyorService.save(ConveyorMapper.toModel(conveyorRequest))));
    }

    @GetMapping("/{conveyorId}")
    public ResponseEntity<ConveyorResponse> findById(@PathVariable String conveyorId) {
        return ResponseEntity
                .ok()
                .body(ConveyorMapper.toResponse(conveyorService.findById(UUID.fromString(conveyorId))));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ConveyorModel>> findAll(Pageable pageable,
                                                       @RequestParam(name = "conveyor", required = false) String conveyor,
                                                       @RequestParam(name = "address", required = false) String address,
                                                       @RequestParam(name = "district", required = false) String district,
                                                       @RequestParam(name = "zipCode", required = false) String zipCode,
                                                       @RequestParam(name = "cnpj", required = false) String cnpj,
                                                       @RequestParam(name = "contact", required = false) String contact) {
        return ResponseEntity.ok().body(conveyorService.findAll(pageable, conveyor, address, district, zipCode, cnpj, contact));
    }

    @PutMapping("/{conveyorId}")
    public ResponseEntity<ConveyorResponse> update(@PathVariable String conveyorId, @RequestBody ConveyorRequest conveyorRequest) {
        return ResponseEntity.ok()
                .body(ConveyorMapper.toResponse(conveyorService.update(ConveyorMapper.toModel(conveyorRequest), UUID.fromString(conveyorId))));
    }

    @DeleteMapping("/{conveyorId}")
    public ResponseEntity<UUID> delete(@PathVariable String conveyorId) {
        return ResponseEntity.ok()
                .body(conveyorService.delete(UUID.fromString(conveyorId)));
    }

}
