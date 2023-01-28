package com.github.dev.inventory.controller;

import com.github.dev.inventory.entity.Entry;
import com.github.dev.inventory.service.EntryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Log
@Validated
@RestController
@AllArgsConstructor
@RequestMapping("/v1/entry")
public class EntryController {

    private final EntryService entryService;

    @PostMapping
    public ResponseEntity<Entry> save(@Valid @RequestBody final Entry entry) throws Exception {
        log.info("POST /v1/entry " + entry);
        return ResponseEntity.status(HttpStatus.CREATED).body(entryService.save(entry));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Entry>> findAll() throws Exception {
        log.info("GET /v1/entry/all");
        return ResponseEntity.ok().body(entryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Entry> findById(UUID id) throws Exception {
        log.info("GET /v1/entry/" + id);
        return ResponseEntity.ok().body(entryService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Entry> update(Entry entry, UUID id) {
        log.info("PUT /v1/entry/" + id);
        return ResponseEntity.ok().body(entryService.update(entry, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> deleteById(UUID id) {
        log.info("DELETE /v1/entry/" + id);
        var code = entryService.deleteById(id);
        return ResponseEntity.accepted().body("Record " + code + " deleted from database.");
    }

}
