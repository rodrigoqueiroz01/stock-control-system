package com.github.dev.inventory.service;

import com.github.dev.inventory.entity.Entry;
import com.github.dev.inventory.exception.EntityNotFoundException;
import com.github.dev.inventory.repository.EntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EntryService {

    private final EntryRepository entryRepository;

    public Entry save(Entry entry) {
        return entryRepository.save(entry);
    }

    public List<Entry> findAll() {
        return entryRepository.findAll();
    }

    public Entry findById(UUID id) {
        return entryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No records found for this code in the system."));
    }

    public Entry update(Entry entry, UUID id) {
        findById(id);
        entry.setId(id);
        return save(entry);
    }

    public Object deleteById(UUID id) {
        var entry = findById(id);
        entryRepository.deleteById(entry.getId());
        return String.valueOf(entry.getId());
    }

}
