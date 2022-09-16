package inventory.control.domain.service;

import inventory.control.domain.exception.alreadyregistered.ProhibitedAlreadyRegisteredException;
import inventory.control.domain.exception.notfound.ProhibitedNotFoundException;
import inventory.control.domain.model.ProhibitedModel;
import inventory.control.domain.repository.ProhibitedRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProhibitedService {

    private final ProhibitedRepository prohibitedRepository;

    public ProhibitedModel save(ProhibitedModel prohibitedModel) {
        return prohibitedRepository.save(prohibitedModel);
    }

    public ProhibitedModel findById(UUID id) {
        return prohibitedRepository.findById(id)
                .orElseThrow(() -> new ProhibitedAlreadyRegisteredException("Entrada não encontrada!"));
    }

    public List<ProhibitedModel> findAll() {
        return prohibitedRepository.findAll();
    }

    public ProhibitedModel update(ProhibitedModel prohibitedModel, UUID id) {
        prohibitedRepository.findById(id)
                .orElseThrow(() -> new ProhibitedNotFoundException("Entrada não encontrada!"));
        prohibitedModel.setId(id);
        prohibitedRepository.save(prohibitedModel);
        return prohibitedModel;
    }

    public UUID delete(UUID id) {
        var prohibited = prohibitedRepository.findById(id)
                .orElseThrow(() -> new ProhibitedNotFoundException("Entrada não encontrada!"));
        prohibitedRepository.delete(prohibited);
        return id;
    }

}
