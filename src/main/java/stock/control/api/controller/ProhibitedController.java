package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.ProhibitedRequest;
import stock.control.api.dto.response.ProhibitedResponse;
import stock.control.api.dto.mapper.ProhibitedMapper;
import stock.control.domain.service.ProhibitedService;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProhibitedMapper.toResponse(prohibitedService.save(ProhibitedMapper.toModel(prohibitedRequest))));
    }

    @GetMapping("/{prohibitedId}")
    public ResponseEntity<ProhibitedResponse> findById(@PathVariable String prohibitedId) {
        return ResponseEntity.ok().body(ProhibitedMapper.toResponse(prohibitedService.findById(UUID.fromString(prohibitedId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProhibitedResponse>> findAll() {
        return ResponseEntity.ok().body(ProhibitedMapper.toResponseList(prohibitedService.findAll()));
    }

    @PutMapping("/{prohibitedId}")
    public ResponseEntity<ProhibitedResponse> update(@Valid @RequestBody ProhibitedRequest prohibitedRequest,
                                                     @PathVariable String prohibitedId) {
        return ResponseEntity.ok()
                .body(ProhibitedMapper.toResponse(prohibitedService.update(ProhibitedMapper.toModel(prohibitedRequest),
                        UUID.fromString(prohibitedId))));
    }

    @DeleteMapping("/{prohibitedId}")
    public ResponseEntity<Object> delete(@PathVariable String prohibitedId) {
        String code = String.valueOf(prohibitedService.delete(UUID.fromString(prohibitedId)));

        return ResponseEntity.ok().body("Entrada de código " + code + " deletada!");
    }

}
