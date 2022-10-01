package stock.control.api.controller;

import org.springframework.http.HttpStatus;
import stock.control.api.dto.request.ProviderRequest;
import stock.control.api.dto.response.ProviderResponse;
import stock.control.api.dto.mapper.ProviderMapper;
import stock.control.domain.model.ProviderModel;
import stock.control.domain.service.ProviderService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/providers")
@AllArgsConstructor
@Validated
public class ProviderController {

    private final ProviderService providerService;

    @PostMapping
    public ResponseEntity<ProviderResponse> save(@Valid @RequestBody ProviderRequest providerRequest) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ProviderMapper.toResponse(providerService.save(ProviderMapper.toModel(providerRequest))));
    }

    @GetMapping("/{providerId}")
    public ResponseEntity<ProviderResponse> findById(@PathVariable String providerId) {
        return ResponseEntity.ok().body(ProviderMapper.toResponse(providerService.findById(UUID.fromString(providerId))));
    }

    @GetMapping("/all")
    public ResponseEntity<Page<ProviderModel>> findAll(Pageable pageable,
                                                       @RequestParam(name = "provider", required = false) String provider,
                                                       @RequestParam(name = "address", required = false) String address,
                                                       @RequestParam(name = "district", required = false) String district,
                                                       @RequestParam(name = "cep", required = false) String cep,
                                                       @RequestParam(name = "contact", required = false) String contact,
                                                       @RequestParam(name = "cnpj", required = false) String cnpj,
                                                       @RequestParam(name = "subscription", required = false) String subscription) {
        return ResponseEntity.ok().body(providerService.findAll(pageable, provider, address, district, cep, contact, cnpj, subscription));
    }

    @PutMapping("/{providerId}")
    public ResponseEntity<ProviderResponse> update(@Valid @RequestBody ProviderRequest providerRequest, @PathVariable String providerId) {
        return ResponseEntity.ok()
                .body(ProviderMapper.toResponse(providerService.update(ProviderMapper.toModel(providerRequest),
                        UUID.fromString(providerId))));
    }

    @DeleteMapping("/{providerId}")
    public ResponseEntity<Object> delete(@PathVariable String providerId) {
        String code = String.valueOf(providerService.delete(UUID.fromString(providerId)));

        return ResponseEntity.ok().body("Fornecedor de código " + code + " deletado!");
    }

}
