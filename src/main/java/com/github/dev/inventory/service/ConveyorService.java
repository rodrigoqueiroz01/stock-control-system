package com.github.dev.inventory.service;

import com.github.dev.inventory.entity.Conveyor;
import com.github.dev.inventory.exception.DataAlreadyRegisteredException;
import com.github.dev.inventory.exception.EntityNotFoundException;
import com.github.dev.inventory.model.Address;
import com.github.dev.inventory.repository.ConveyorRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConveyorService {

    private final ConveyorRepository conveyorRepository;

    public Conveyor save(Conveyor conveyor) {
        if (!Objects.isNull(conveyorRepository.findByNameConveyor(conveyor.getNameConveyor()))) {
            throw new DataAlreadyRegisteredException("Conveyor already registered in the system.");
        }

        return conveyorRepository.save(conveyor);
    }

    public List<Conveyor> findAll(String nameConveyor, Address address) {
        return conveyorRepository.findAll(((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (nameConveyor != null && !nameConveyor.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("nameConveyor")),
                        "%" + nameConveyor.toLowerCase() + "%"));
            }

            if (address.getCountry() != null && !address.getCountry().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("country")),
                        "%" + address.getCountry().toLowerCase() + "%"));
            }

            if (address.getState() != null && !address.getState().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("state")),
                        "%" + address.getState().toLowerCase() + "%"));
            }

            if (address.getCity() != null && !address.getCity().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("city")),
                        "%" + address.getCity().toLowerCase() + "%"));
            }

            if (address.getDistrict() != null && !address.getDistrict().isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("district")),
                        "%" + address.getDistrict().toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        }));
    }

    public Conveyor findById(UUID id) {
        return conveyorRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No records found for this code in the system."));
    }

    public Conveyor update(Conveyor conveyor, UUID id) {
        findById(id);
        conveyor.setId(id);
        return save(conveyor);
    }

    public Object deleteById(UUID id) {
        var conveyor = findById(id);
        conveyorRepository.deleteById(conveyor.getId());
        return String.valueOf(conveyor.getId());
    }

}
