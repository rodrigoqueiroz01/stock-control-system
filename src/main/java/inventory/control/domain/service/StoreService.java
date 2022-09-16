package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.StoreAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.StoreNotFoundException;
import inventory.control.domain.model.StoreModel;
import inventory.control.domain.repository.StoreRepository;
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
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreModel save(StoreModel storeModel) {
        if (!Objects.isNull(storeRepository.findByName(storeModel.getName()))) {
            throw new StoreAlreadyRegisteredException("Já existe loja com esse nome!");
        } else {
            return storeRepository.save(storeModel);
        }
    }

    public StoreModel findById(UUID id) {
        return storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException("Loja não encontrada!"));
    }

    public Page<StoreModel> findAll(Pageable pageable, String zipCode, String address, String district) {
        return this.storeRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (zipCode != null && !zipCode.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("zipCode")),
                        "%" + zipCode.toLowerCase() + "%"));
            }

            if (address != null && !address.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("address")),
                        "%" + address.toLowerCase() + "%"));
            }

            if (district != null && !district.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("district")),
                        "%" + district.toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        }, pageable);
    }

    public StoreModel update(StoreModel storeModel, UUID id) {
        storeRepository.findById(id).orElseThrow(() -> new StoreNotFoundException("Loja não encontrada!"));
        storeModel.setId(id);

        if (!Objects.isNull(storeRepository.findByName(storeModel.getName()))) {
            throw new StoreAlreadyRegisteredException("Já existe loja com esse nome!");
        } else {
            storeRepository.save(storeModel);
            return storeModel;
        }
    }

    public UUID delete(UUID id) {
        var store = storeRepository.findById(id)
                .orElseThrow(() -> new StoreNotFoundException("Loja não encontrada!"));
        storeRepository.delete(store);
        return id;
    }

}
