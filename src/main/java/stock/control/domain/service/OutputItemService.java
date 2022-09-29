package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import stock.control.domain.model.OutputItemModel;
import stock.control.domain.repository.OutputItemRepository;
import stock.control.exception.DataNotFoundException;
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
        return outputItemRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Ítem de saída não encontrado na base de dados!"));
    }

    public List<OutputItemModel> findAll() {
        return outputItemRepository.findAll();
    }

    public OutputItemModel update(OutputItemModel outputItemModel, UUID id) {
        outputItemRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Ítem de saída não encontrado na base de dados!"));
        outputItemModel.setId(id);

        return outputItemRepository.save(outputItemModel);
    }

    public UUID delete(UUID id) {
        OutputItemModel outputItem = outputItemRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Ítem de saída não encontrado na base de dados!"));
        outputItemRepository.delete(outputItem);

        return id;
    }

}
