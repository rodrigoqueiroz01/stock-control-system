package inventory.control.api.controller;

import inventory.control.api.dto.request.ExitRequest;
import inventory.control.api.dto.response.ExitResponse;
import inventory.control.api.mapper.ExitMapper;
import inventory.control.domain.service.ExitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/exits")
@AllArgsConstructor
@Validated
public class ExitController {

    private final ExitService exitService;

    @PostMapping
    public ResponseEntity<ExitResponse> save(@Valid @RequestBody ExitRequest exitRequest) {
        return ResponseEntity.ok()
                .body(ExitMapper.toResponse(exitService.save(ExitMapper.toModel(exitRequest))));
    }

    @GetMapping("/{exitId}")
    public ResponseEntity<ExitResponse> findById(@PathVariable String exitId) {
        return ResponseEntity.ok()
                .body(ExitMapper.toResponse(exitService.findById(UUID.fromString(exitId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExitResponse>> findAll() {
        return ResponseEntity.ok()
                .body(ExitMapper.toResponseList(exitService.findAll()));
    }

    @PutMapping("/{exitId}")
    public ResponseEntity<ExitResponse> update(@PathVariable String exitId, @RequestBody ExitRequest exitRequest) {
        return ResponseEntity.ok()
                .body(ExitMapper.toResponse(exitService.update(ExitMapper.toModel(exitRequest), UUID.fromString(exitId))));
    }

    @DeleteMapping("/{exitId}")
    public ResponseEntity<UUID> delete(@PathVariable String exitId) {
        return ResponseEntity.ok()
                .body(exitService.delete(UUID.fromString(exitId)));
    }

}
