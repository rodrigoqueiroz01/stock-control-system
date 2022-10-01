package stock.control.api.dto.mapper;

import stock.control.api.dto.request.ProviderRequest;
import stock.control.api.dto.response.ProviderResponse;
import stock.control.domain.model.ProviderModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ProviderMapper {

    public static ProviderModel toModel(ProviderRequest request) {
        return ProviderModel
                .builder()
                    .name(request.getProvider())
                    .address(request.getAddress())
                    .number(request.getNumber())
                    .district(request.getDistrict())
                    .cep(request.getCep())
                    .contact(request.getContact())
                    .cnpj(request.getCnpj())
                    .subscription(request.getSubscription())
                    .telephone(request.getTelephone())
                .build();
    }

    public static ProviderResponse toResponse(ProviderModel providerModel) {
        return ProviderResponse
                .builder()
                    .id(providerModel.getId())
                    .name(providerModel.getName())
                    .address(providerModel.getAddress())
                    .number(providerModel.getNumber())
                    .district(providerModel.getDistrict())
                    .cep(providerModel.getCep())
                    .contact(providerModel.getContact())
                    .cnpj(providerModel.getCnpj())
                    .subscription(providerModel.getSubscription())
                    .telephone(providerModel.getTelephone())
                .build();
    }

    public static List<ProviderResponse> toResponseList(List<ProviderModel> providerModelList) {
        if (isNull(providerModelList) || providerModelList.isEmpty()) {
            return new ArrayList<>();
        }

        return providerModelList
                    .stream()
                    .map(ProviderMapper::toResponse)
                    .collect(Collectors.toList());
    }

    public static List<ProviderModel> toModelList(List<UUID> idList) {
        return idList
                .stream()
                .map(ProviderMapper::createProvider)
                .collect(Collectors.toList());
    }

    public static ProviderModel createProvider(UUID id) {
        return ProviderModel
                .builder()
                    .id(id)
                .build();
    }

}
