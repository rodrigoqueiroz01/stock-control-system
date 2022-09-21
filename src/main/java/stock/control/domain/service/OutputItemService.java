package stock.control.domain.service;

import stock.control.exception.notfound.OutputItemNotFoundException;
import stock.control.domain.model.OutputItemModel;
import stock.control.domain.repository.OutputItemRepository;
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
        return outputItemRepository.findById(id).orElseThrow(() -> new OutputItemNotFoundException());
    }

    public List<OutputItemModel> findAll() {
        return outputItemRepository.findAll();
    }

    public OutputItemModel update(OutputItemModel outputItemModel, UUID id) {
        outputItemRepository.findById(id).orElseThrow(() -> new OutputItemNotFoundException());
        outputItemModel.setId(id);

        return outputItemRepository.save(outputItemModel);
    }

    public UUID delete(UUID id) {
        OutputItemModel outputItem = outputItemRepository.findById(id).orElseThrow(() -> new OutputItemNotFoundException());
        outputItemRepository.delete(outputItem);

        return id;
    }

}
