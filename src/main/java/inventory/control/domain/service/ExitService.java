package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.ExitAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.ExitNotFoundException;
import inventory.control.domain.model.ExitModel;
import inventory.control.domain.repository.ExitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
        return exitRepository.findById(id)
                .orElseThrow(() -> new ExitAlreadyRegisteredException("Saída não encontrada!"));
    }

    public List<ExitModel> findAll() {
        return exitRepository.findAll();
    }

    public ExitModel update(ExitModel exitModel, UUID id) {
        exitRepository.findById(id)
                .orElseThrow(() -> new ExitNotFoundException("Saída não encontrada!"));
        exitModel.setId(id);
        exitRepository.save(exitModel);
        return exitModel;
    }

    public UUID delete(UUID id) {
        var exit = exitRepository.findById(id)
                .orElseThrow(() -> new ExitNotFoundException("Saída não encontrada!"));
        exitRepository.delete(exit);
        return id;
    }

}
