package inventory.control.api.mapper;

import inventory.control.api.dto.request.CityRequest;
import inventory.control.api.dto.response.CityResponse;
import inventory.control.domain.model.CityModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class CityMapper {

    public static CityModel toModel(CityRequest request) {
        return CityModel
                .builder()
                .city(request.getCity())
                .uf(request.getUf())
                .build();
    }

    public static CityResponse toResponse(CityModel cityModel) {
        return CityResponse
                .builder()
                .id(cityModel.getId())
                .city(cityModel.getCity())
                .uf(cityModel.getUf())
                .build();
    }

    public static List<CityResponse> toResponseList(List<CityModel> cityModelList) {
        if (isNull(cityModelList) || cityModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return cityModelList
                    .stream()
                    .map(CityMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

    public static List<CityModel> toModelList(List<UUID> idList) {
        return idList
                .stream()
                .map(CityMapper::createCity)
                .collect(Collectors.toList());
    }

    public static CityModel createCity(UUID id) {
        return CityModel
                .builder()
                .id(id)
                .build();
    }

}
