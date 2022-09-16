package inventory.control.api.controller;

import inventory.control.api.dto.request.CityRequest;
import inventory.control.api.dto.response.CityResponse;
import inventory.control.api.mapper.CityMapper;
import inventory.control.domain.service.CityService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cities")
@AllArgsConstructor
@Validated
public class CityController {

    private final CityService cityService;

    @PostMapping
    public ResponseEntity<CityResponse> save(@Valid @RequestBody CityRequest cityRequest) {
        return ResponseEntity
                .ok()
                .body(CityMapper.toResponse(cityService.save(CityMapper.toModel(cityRequest))));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityResponse> findById(@PathVariable String cityId) {
        return ResponseEntity
                .ok()
                .body(CityMapper.toResponse(cityService.findById(UUID.fromString(cityId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityResponse>> findAll() {
        return ResponseEntity
                .ok()
                .body(CityMapper.toResponseList(cityService.findAll()));
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityResponse> update(@PathVariable String cityId, @RequestBody CityRequest cityRequest) {
        return ResponseEntity
                .ok()
                .body(CityMapper.toResponse(cityService.update(CityMapper.toModel(cityRequest), UUID.fromString(cityId))));
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<UUID> delete(@PathVariable String cityId) {
        return ResponseEntity
                .ok()
                .body(cityService.delete(UUID.fromString(cityId)));
    }

}
