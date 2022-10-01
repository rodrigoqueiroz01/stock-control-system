package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.CityRequest;
import stock.control.api.dto.response.CityResponse;
import stock.control.api.dto.mapper.CityMapper;
import stock.control.domain.service.CityService;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(CityMapper.toResponse(cityService.save(CityMapper.toModel(cityRequest))));
    }

    @GetMapping("/{cityId}")
    public ResponseEntity<CityResponse> findById(@PathVariable String cityId) {
        return ResponseEntity.ok().body(CityMapper.toResponse(cityService.findById(UUID.fromString(cityId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CityResponse>> findAll() {
        return ResponseEntity.ok().body(CityMapper.toResponseList(cityService.findAll()));
    }

    @PutMapping("/{cityId}")
    public ResponseEntity<CityResponse> update(@Valid @RequestBody CityRequest cityRequest, @PathVariable String cityId) {
        return ResponseEntity.ok()
                .body(CityMapper.toResponse(cityService.update(CityMapper.toModel(cityRequest), UUID.fromString(cityId))));
    }

    @DeleteMapping("/{cityId}")
    public ResponseEntity<Object> delete(@PathVariable String cityId) {
        String code = String.valueOf(cityService.delete(UUID.fromString(cityId)));

        return ResponseEntity.ok().body("Cidade de código " + code  + " deletada!");
    }

}
