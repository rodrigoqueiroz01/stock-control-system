package inventory.control.domain.service;

import inventory.control.domain.exception.notfound.OutputItemNotFoundException;
import inventory.control.domain.model.OutputItemModel;
import inventory.control.domain.repository.OutputItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class OutputItemService {

    private final OutputItemRepository outputItemRepository;

    public OutputItemModel save(OutputItemModel outputItemModel) {
        return outputItemRepository.save(outputItemModel);
    }

    public OutputItemModel findById(UUID id) {
        return outputItemRepository.findById(id)
                .orElseThrow(() -> new OutputItemNotFoundException("Item de saída não encontrado!"));
    }

    public List<OutputItemModel> findAll() {
        return outputItemRepository.findAll();
    }

    public OutputItemModel update(OutputItemModel outputItemModel, UUID id) {
        outputItemRepository.findById(id)
                .orElseThrow(() -> new OutputItemNotFoundException("Item de saída não encontrado!"));
        outputItemModel.setId(id);
        outputItemRepository.save(outputItemModel);
        return outputItemModel;
    }

    public UUID delete(UUID uuid) {
        var outputItem = outputItemRepository.findById(uuid)
                .orElseThrow(() -> new OutputItemNotFoundException("Item de saída não encontrado!"));
        outputItemRepository.delete(outputItem);
        return uuid;
    }

}
