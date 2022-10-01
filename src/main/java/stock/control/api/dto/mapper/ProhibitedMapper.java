package stock.control.api.dto.mapper;

import stock.control.api.dto.request.ProhibitedRequest;
import stock.control.api.dto.response.ProhibitedResponse;
import stock.control.domain.model.ProhibitedModel;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Objects.isNull;

@Component
public class ProhibitedMapper {

    public static ProhibitedModel toModel(ProhibitedRequest request) {
        return ProhibitedModel
                .builder()
                    .requestDate(request.getRequestDate())
                    .entryDate(request.getEntryDate())
                    .total(request.getTotal())
                    .shipping(request.getShipping())
                    .invoiceNumber(request.getInvoiceNumber())
                    .tax(request.getTax())
                .build();
    }

    public static ProhibitedResponse toResponse(ProhibitedModel prohibitedModel) {
        return ProhibitedResponse
                .builder()
                    .id(prohibitedModel.getId())
                    .requestDate(prohibitedModel.getRequestDate())
                    .entryDate(prohibitedModel.getEntryDate())
                    .total(prohibitedModel.getTotal())
                    .shipping(prohibitedModel.getShipping())
                    .invoiceNumber(prohibitedModel.getInvoiceNumber())
                    .tax(prohibitedModel.getTax())
                .build();
    }

    public static List<ProhibitedResponse> toResponseList(List<ProhibitedModel> prohibitedModelList) {
        if (isNull(prohibitedModelList) || prohibitedModelList.isEmpty()) {
            return new ArrayList<>();
        }

        return prohibitedModelList
                    .stream()
                    .map(ProhibitedMapper::toResponse)
                    .collect(Collectors.toList());
    }

}
