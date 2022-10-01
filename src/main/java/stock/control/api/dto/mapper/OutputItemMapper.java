package stock.control.api.dto.mapper;

import stock.control.api.dto.request.OutpuItemRequest;
import stock.control.api.dto.response.OutputItemResponse;
import stock.control.domain.model.OutputItemModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class OutputItemMapper {

    public static OutputItemModel toModel(OutpuItemRequest request) {
        return OutputItemModel
                .builder()
                    .batch(request.getBatch())
                    .amount(request.getAmount())
                    .value(request.getValue())
                .build();
    }

    public static OutputItemResponse toResponse(OutputItemModel outputItemModel) {
        return OutputItemResponse
                .builder()
                    .id(outputItemModel.getId())
                    .batch(outputItemModel.getBatch())
                    .amount(outputItemModel.getAmount())
                    .value(outputItemModel.getValue())
                .build();
    }

    public static List<OutputItemResponse> toResponseList(List<OutputItemModel> outputItemModelList) {
        if (isNull(outputItemModelList) || outputItemModelList.isEmpty()) {
            return new ArrayList<>();
        }

        return outputItemModelList
                .stream()
                .map(OutputItemMapper::toResponse)
                .collect(Collectors.toList());

    }

}
