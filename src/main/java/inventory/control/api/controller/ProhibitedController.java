package inventory.control.api.controller;

import inventory.control.api.dto.request.ProhibitedRequest;
import inventory.control.api.dto.response.ProhibitedResponse;
import inventory.control.api.mapper.ProhibitedMapper;
import inventory.control.domain.service.ProhibitedService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/prohibited")
@AllArgsConstructor
@Validated
public class ProhibitedController {

    private final ProhibitedService prohibitedService;

    @PostMapping
    public ResponseEntity<ProhibitedResponse> save(@Valid @RequestBody ProhibitedRequest prohibitedRequest) {
        return ResponseEntity
                .ok()
                .body(ProhibitedMapper.toResponse(prohibitedService.save(ProhibitedMapper.toModel(prohibitedRequest))));
    }

    @GetMapping("/{prohibitedId}")
    public ResponseEntity<ProhibitedResponse> findById(@PathVariable String prohibitedId) {
        return ResponseEntity
                .ok()
                .body(ProhibitedMapper.toResponse(prohibitedService.findById(UUID.fromString(prohibitedId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProhibitedResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(ProhibitedMapper.toResponseList(prohibitedService.findAll()));
    }

    @PutMapping("/{prohibitedId}")
    public ResponseEntity<ProhibitedResponse> update(@PathVariable String prohibitedId, @RequestBody ProhibitedRequest prohibitedRequest) {
        return ResponseEntity
                .ok()
                .body(ProhibitedMapper.toResponse(prohibitedService.update(ProhibitedMapper.toModel(prohibitedRequest), UUID.fromString(prohibitedId))));
    }

    @DeleteMapping("/{prohibitedId}")
    public ResponseEntity<UUID> delete(@PathVariable String prohibitedId) {
        return ResponseEntity
                .ok()
                .body(prohibitedService.delete(UUID.fromString(prohibitedId)));
    }

}
