package inventory.control.api.mapper;

import inventory.control.api.dto.request.StoreRequest;
import inventory.control.api.dto.response.StoreResponse;
import inventory.control.domain.model.StoreModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class StoreMapper {

    public static StoreModel toModel(StoreRequest storeRequest) {
        return StoreModel
                .builder()
                .name(storeRequest.getName())
                .zipCode(storeRequest.getZipCode())
                .address(storeRequest.getAddress())
                .number(storeRequest.getNumber())
                .district(storeRequest.getDistrict())
                .telephone(storeRequest.getTelephone())
                .subscription(storeRequest.getSubscription())
                .cnpj(storeRequest.getCnpj())
//                .cityModels(CityMapper.toModelList(storeRequest.getCodCityList()))
                .build();
    }

    public static StoreResponse toResponse(StoreModel storeModel) {
        return StoreResponse
                .builder()
                .id(storeModel.getId())
                .name(storeModel.getName())
                .zipCode(storeModel.getZipCode())
                .address(storeModel.getAddress())
                .number(storeModel.getNumber())
                .district(storeModel.getDistrict())
                .telephone(storeModel.getTelephone())
                .subscription(storeModel.getSubscription())
                .cnpj(storeModel.getCnpj())
//                .cityResponseList(CityMapper.toResponseList(storeModel.getCityModels()))
                .build();
    }

    public static List<StoreResponse> toResponseList(List<StoreModel> storeModelList) {
        if (isNull(storeModelList) || storeModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return storeModelList
                    .stream()
                    .map(StoreMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
