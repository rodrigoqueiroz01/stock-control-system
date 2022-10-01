package stock.control.api.dto.mapper;

import stock.control.api.dto.request.ExitRequest;
import stock.control.api.dto.response.ExitResponse;
import stock.control.domain.model.ExitModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ExitMapper {

    public static ExitModel toModel(ExitRequest request) {
        return ExitModel
                .builder()
                    .total(request.getTotal())
                    .shipping(request.getShipping())
                    .tax(request.getTax())
                .build();
    }

    public static ExitResponse toResponse(ExitModel exitModel) {
        return ExitResponse
                .builder()
                    .id(exitModel.getId())
                    .total(exitModel.getTotal())
                    .shipping(exitModel.getShipping())
                    .tax(exitModel.getTax())
                .build();
    }

    public static List<ExitResponse> toResponseList(List<ExitModel> exitModelList) {
        if (isNull(exitModelList) || exitModelList.isEmpty()) {
            return new ArrayList<>();
        }

        return exitModelList
                    .stream()
                    .map(ExitMapper::toResponse)
                    .collect(Collectors.toList());
    }

}
