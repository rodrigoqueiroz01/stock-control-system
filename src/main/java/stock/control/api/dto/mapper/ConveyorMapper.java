package stock.control.api.dto.mapper;

import stock.control.api.dto.request.ConveyorRequest;
import stock.control.api.dto.response.ConveyorResponse;
import stock.control.domain.model.ConveyorModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ConveyorMapper {

    public static ConveyorModel toModel(ConveyorRequest request) {
        return ConveyorModel
                .builder()
                    .name(request.getName())
                    .address(request.getAddress())
                    .number(request.getNumber())
                    .district(request.getDistrict())
                    .zipCode(request.getZipCode())
                    .cnpj(request.getCnpj())
                    .subscription(request.getSubscription())
                    .contact(request.getContact())
                    .telephone(request.getTelephone())
                .build();
    }

    public static ConveyorResponse toResponse(ConveyorModel conveyorModel) {
        return ConveyorResponse
                .builder()
                    .id(conveyorModel.getId())
                    .name(conveyorModel.getName())
                    .address(conveyorModel.getAddress())
                    .number(conveyorModel.getNumber())
                    .district(conveyorModel.getDistrict())
                    .zipCode(conveyorModel.getZipCode())
                    .cnpj(conveyorModel.getCnpj())
                    .subscription(conveyorModel.getSubscription())
                    .contact(conveyorModel.getContact())
                    .telephone(conveyorModel.getTelephone())
                .build();
    }

    public static List<ConveyorResponse> toResponseList(List<ConveyorModel> conveyorModelList) {
        if (isNull(conveyorModelList) || conveyorModelList.isEmpty()) {
            return new ArrayList<>();
        }

        return conveyorModelList
                    .stream()
                    .map(ConveyorMapper::toResponse)
                    .collect(Collectors.toList());
    }

    public static List<ConveyorModel> toModelList(List<UUID> idList) {
        return idList
                .stream()
                .map(ConveyorMapper::createConveyor)
                .collect(Collectors.toList());
    }

    public static ConveyorModel createConveyor(UUID id) {
        return ConveyorModel
                .builder()
                    .id(id)
                .build();
    }

}
