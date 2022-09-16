package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.EntryItemAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.EntryItemNotFoundException;
import inventory.control.domain.model.EntryItemModel;
import inventory.control.domain.repository.EntryItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class EntryItemService {

    private final EntryItemRepository entryItemRepository;

    public EntryItemModel save(EntryItemModel entryItemModel) {
        return entryItemRepository.save(entryItemModel);
    }

    public EntryItemModel findById(UUID id) {
        return entryItemRepository.findById(id)
                .orElseThrow(() -> new EntryItemAlreadyRegisteredException("Item de entrada não encontrado!"));
    }

    public Page<EntryItemModel> findAll(Pageable pageable, String batch) {
        return this.entryItemRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (batch != null && !batch.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("batch")),
                        "%" + batch.toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        }, pageable);
    }

    public EntryItemModel update(EntryItemModel entryItemModel, UUID id) {
        entryItemRepository.findById(id)
                .orElseThrow(() -> new EntryItemNotFoundException("Item de entrada não encontrado!"));
        entryItemModel.setId(id);
        entryItemRepository.save(entryItemModel);
        return entryItemModel;
    }

    public UUID delete(UUID id) {
        var entryItem = entryItemRepository.findById(id)
                .orElseThrow(() -> new EntryItemNotFoundException("Item de entrada não encontrado!"));
        entryItemRepository.delete(entryItem);
        return id;
    }

}
