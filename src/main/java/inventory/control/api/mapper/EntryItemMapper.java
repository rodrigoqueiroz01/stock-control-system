package inventory.control.api.mapper;

import inventory.control.api.dto.request.EntryItemRequest;
import inventory.control.api.dto.response.EntryItemResponse;
import inventory.control.domain.model.EntryItemModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class EntryItemMapper {

    public static EntryItemModel toModel(EntryItemRequest request) {
        return EntryItemModel
                .builder()
                .batch(request.getBatch())
                .amount(request.getAmount())
                .value(request.getValue())
//                .productModel(ProductModel.builder().idProduct(request.getCodProduct()).build())
//                .prohibitedModel(ProhibitedModel.builder().idProhibited(request.getCodProhibited()).build())
                .build();
    }

    public static EntryItemResponse toResponse(EntryItemModel entryItemModel) {
        return EntryItemResponse
                .builder()
                .id(entryItemModel.getId())
                .batch(entryItemModel.getBatch())
                .amount(entryItemModel.getAmount())
                .value(entryItemModel.getValue())
//                .productResponse(ProductMapper.toResponse(entryItemModel.getProductModel()))
//                .prohibitedResponse(ProhibitedMapper.toResponse(entryItemModel.getProhibitedModel()))
                .build();
    }

    public static List<EntryItemResponse> toResponseList(List<EntryItemModel> entryItemModelList) {
        if(isNull(entryItemModelList) || entryItemModelList.isEmpty()) {
            return new ArrayList<>();
        } else {
            return entryItemModelList
                    .stream()
                    .map(EntryItemMapper::toResponse)
                    .collect(Collectors.toList());
        }
    }

}
