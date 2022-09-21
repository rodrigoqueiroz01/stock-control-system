package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import stock.control.domain.model.ProhibitedModel;
import stock.control.domain.repository.ProhibitedRepository;
import stock.control.exception.notfound.ProhibitedNotFoundException;
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
        return prohibitedRepository.findById(id).orElseThrow(() -> new ProhibitedNotFoundException());
    }

    public List<ProhibitedModel> findAll() {
        return prohibitedRepository.findAll();
    }

    public ProhibitedModel update(ProhibitedModel prohibitedModel, UUID id) {
        prohibitedRepository.findById(id).orElseThrow(() -> new ProhibitedNotFoundException());
        prohibitedModel.setId(id);

        return prohibitedRepository.save(prohibitedModel);
    }

    public UUID delete(UUID id) {
        ProhibitedModel prohibited = prohibitedRepository.findById(id).orElseThrow(() -> new ProhibitedNotFoundException());
        prohibitedRepository.delete(prohibited);

        return id;
    }

}
