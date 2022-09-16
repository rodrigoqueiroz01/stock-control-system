package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.ConveyorAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.ConveyorNotFoundException;
import inventory.control.domain.model.ConveyorModel;
import inventory.control.domain.repository.ConveyorRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ConveyorService {

    private final ConveyorRepository conveyorRepository;

    public ConveyorModel save(ConveyorModel conveyorModel) {
        if (!Objects.isNull(conveyorRepository.findByConveyor(conveyorModel.getConveyor()))) {
            throw new ConveyorAlreadyRegisteredException("Transportadora já cadastrada no sistema!");
        } else {
            return conveyorRepository.save(conveyorModel);
        }
    }

    public ConveyorModel findById(UUID id) {
        return conveyorRepository.findById(id)
                .orElseThrow(() -> new ConveyorNotFoundException("Transportadora não encontrada!"));
    }

    public Page<ConveyorModel> findAll(Pageable pageable, String conveyor, String address, String district, String zipCode, String cnpj, String contact) {
        return this.conveyorRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (conveyor != null && !conveyor.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("conveyor")),
                        "%" + conveyor.toLowerCase() + "%"));
            }

            if (address != null && !address.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("address")),
                        "%" + address.toLowerCase() + "%"));
            }

            if (district != null && !district.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("district")),
                        "%" + district.toLowerCase() + "%"));
            }

            if (zipCode != null && !zipCode.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("zipCode")),
                        "%" + zipCode.isEmpty() + "%"));
            }

            if (cnpj != null && !cnpj.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("cnpj")),
                        "%" + cnpj.isEmpty() + "%"));
            }

            if (contact != null && !contact.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("contact")),
                        "%" + contact.isEmpty() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        }, pageable);
    }

    public ConveyorModel update(ConveyorModel conveyorModel, UUID id) {
        conveyorRepository.findById(id)
                .orElseThrow(() -> new ConveyorNotFoundException("Transportadora não encontrada!"));
        conveyorModel.setId(id);

        if (!Objects.isNull(conveyorRepository.findByConveyor(conveyorModel.getConveyor()))) {
            throw new ConveyorAlreadyRegisteredException("Transportadora já cadastrada no sistema!");
        } else {
            conveyorRepository.save(conveyorModel);
        }

        return conveyorModel;
    }

    public UUID delete(UUID id) {
        var conveyor = conveyorRepository.findById(id)
                .orElseThrow(() -> new ConveyorNotFoundException("Transportadora não encontrada!"));
        conveyorRepository.delete(conveyor);
        return id;
    }

}
