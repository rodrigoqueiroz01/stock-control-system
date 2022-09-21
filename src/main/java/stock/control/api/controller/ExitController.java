package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.ExitRequest;
import stock.control.api.dto.response.ExitResponse;
import stock.control.api.mapper.ExitMapper;
import stock.control.domain.service.ExitService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/exits")
@AllArgsConstructor
@Validated
public class ExitController {

    private final ExitService exitService;

    @PostMapping
    public ResponseEntity<ExitResponse> save(@Valid @RequestBody ExitRequest exitRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ExitMapper.toResponse(exitService.save(ExitMapper.toModel(exitRequest))));
    }

    @GetMapping("/{exitId}")
    public ResponseEntity<ExitResponse> findById(@PathVariable String exitId) {
        return ResponseEntity.ok().body(ExitMapper.toResponse(exitService.findById(UUID.fromString(exitId))));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ExitResponse>> findAll() {
        return ResponseEntity.ok().body(ExitMapper.toResponseList(exitService.findAll()));
    }

    @PutMapping("/{exitId}")
    public ResponseEntity<ExitResponse> update(@Valid @RequestBody ExitRequest exitRequest, @PathVariable String exitId) {
        return ResponseEntity.ok()
                .body(ExitMapper.toResponse(exitService.update(ExitMapper.toModel(exitRequest), UUID.fromString(exitId))));
    }

    @DeleteMapping("/{exitId}")
    public ResponseEntity<Object> delete(@PathVariable String exitId) {
        String code = String.valueOf(exitService.delete(UUID.fromString(exitId)));

        return ResponseEntity.ok().body("Saída de código " + code + " deletada!");
    }

}
