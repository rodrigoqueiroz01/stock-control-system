package com.github.dev.inventory.controller;

import com.github.dev.inventory.controller.interfaces.IConveyorController;
import com.github.dev.inventory.entity.Conveyor;
import com.github.dev.inventory.model.Address;
import com.github.dev.inventory.service.ConveyorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Log
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/v1/conveyors")
public class ConveyorController implements IConveyorController {

    private final ConveyorService conveyorService;

    @PostMapping
    public ResponseEntity<Conveyor> save(@Valid @RequestBody final Conveyor conveyor) throws Exception {
        log.info("POST /v1/conveyor " + conveyor.getNameConveyor());
        return ResponseEntity.ok().body(conveyorService.save(conveyor));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Conveyor>> findAll(@RequestParam(name = "nameConveyor", required = false) String nameConveyor,
                                                  @RequestParam(name = "country", required = false) String country,
                                                  @RequestParam(name = "state", required = false) String state,
                                                  @RequestParam(name = "city", required = false) String city,
                                                  @RequestParam(name = "district", required = false) String district) throws Exception {
        log.info("GET /v1/conveyor/all");
        var list = conveyorService.findAll(nameConveyor, new Address());
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conveyor> findById(@PathVariable UUID id) throws Exception {
        log.info("GET /v1/conveyor/" + id);
        return ResponseEntity.ok().body(conveyorService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Conveyor> update(@Valid @RequestBody final Conveyor conveyor, @PathVariable UUID id) throws Exception {
        log.info("PUT /v1/conveyor/update");
        return ResponseEntity.ok().body(conveyorService.update(conveyor, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable UUID id) throws Exception {
        log.info("DELETE /v1/conveyor/" + id);
        var code = String.valueOf(conveyorService.deleteById(id));
        return ResponseEntity.ok("Record " + code + " deleted from database.");
    }

}
