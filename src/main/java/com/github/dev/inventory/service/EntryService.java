package com.github.dev.inventory.service;

import com.github.dev.inventory.repository.EntryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EntryService {

    private final EntryRepository entryRepository;

}
