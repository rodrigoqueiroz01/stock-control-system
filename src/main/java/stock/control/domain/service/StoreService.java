package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import stock.control.domain.model.StoreModel;
import stock.control.domain.repository.StoreRepository;
import stock.control.exception.DataAlreadyRegisteredException;
import stock.control.exception.DataNotFoundException;
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
            throw new DataAlreadyRegisteredException("Conflito: Loja já cadastrada na base de dados!");
        }

        return storeRepository.save(storeModel);
    }

    public StoreModel findById(UUID id) {
        return storeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Loja não encontrada na base de dados!"));
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
        storeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Loja não encontrada na base de dados!"));
        storeModel.setId(id);

        if (!Objects.isNull(storeRepository.findByName(storeModel.getName()))) {
            throw new DataAlreadyRegisteredException("Conflito: Loja já cadastrada na base de dados!");
        }

        return storeRepository.save(storeModel);

    }

    public UUID delete(UUID id) {
        StoreModel store = storeRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Loja não encontrada na base de dados!"));
        storeRepository.delete(store);

        return id;
    }

}
