package stock.control.domain.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import stock.control.domain.model.ProviderModel;
import stock.control.domain.repository.ProviderRepository;
import stock.control.exception.DataAlreadyRegisteredException;
import stock.control.exception.DataNotFoundException;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProviderService {

    private final ProviderRepository providerRepository;

    public ProviderModel save(ProviderModel providerModel) {
        if (!Objects.isNull(providerRepository.findByProvider(providerModel.getProvider()))) {
            throw new DataAlreadyRegisteredException("Conflito: Fornecedor já cadastrado na base de dados!");
        }

        return providerRepository.save(providerModel);
    }

    public ProviderModel findById(UUID id) {
        return providerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Fornecedor não encontrado na base de dados!"));
    }

    public Page<ProviderModel> findAll(Pageable pageable, String provider, String address, String district, String cep,
                                       String contact, String cnpj, String subscription) {
        return this.providerRepository.findAll((root, query, builder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (provider != null && !provider.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("provider")),
                        "%" + provider.toLowerCase() + "%"));
            }

            if (address != null & !address.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("address")),
                        "%" + address.toLowerCase() + "%"));
            }

            if (district != null && !district.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("district")),
                        "%" + district.toLowerCase() + "%"));
            }

            if (cep != null && !cep.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("cep")),
                        "%" + cep.toLowerCase() + "%"));
            }

            if (contact != null && !contact.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("contact")),
                        "%" + contact.toLowerCase() + "%"));
            }

            if (cnpj != null && !cnpj.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("cnpj")),
                        "%" + cnpj.toLowerCase() + "%"));
            }

            if (subscription != null && !subscription.isEmpty()) {
                predicates.add(builder.like(builder.lower(root.get("subscription")),
                        "%" + subscription.toLowerCase() + "%"));
            }

            return builder.and(predicates.toArray(new Predicate[]{}));
        }, pageable);
    }

    public ProviderModel update(ProviderModel providerModel, UUID id) {
        providerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Fornecedor não encontrado na base de dados!"));
        providerModel.setId(id);

        if (Objects.isNull(providerRepository.findByProvider(providerModel.getProvider()))) {
            throw new DataAlreadyRegisteredException("Conflito: Fornecedor já cadastrado na base de dados!");
        }

        return providerRepository.save(providerModel);
    }

    public UUID delete(UUID id) {
        ProviderModel provider = providerRepository.findById(id).orElseThrow(() -> new DataNotFoundException("Conflito: Fornecedor não encontrado na base de dados!"));
        providerRepository.delete(provider);

        return id;
    }

}
