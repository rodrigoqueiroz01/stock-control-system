package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import stock.control.domain.model.ExitModel;
import stock.control.domain.repository.ExitRepository;
import stock.control.exception.DataNotFoundException;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ExitService {

    private final ExitRepository exitRepository;

    public ExitModel save(ExitModel exitModel) {
            return exitRepository.save(exitModel);
    }

    public ExitModel findById(UUID id) {
        return exitRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Saída não encontrada na base de dados!"));
    }

    public List<ExitModel> findAll() {
        return exitRepository.findAll();
    }

    public ExitModel update(ExitModel exitModel, UUID id) {
        exitRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Saída não encontrada na base de dados!"));
        exitModel.setId(id);

        return exitRepository.save(exitModel);
    }

    public UUID delete(UUID id) {
        ExitModel exit = exitRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Saída não encontrada na base de dados!"));
        exitRepository.delete(exit);

        return id;
    }

}
