package stock.control.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private UUID id;

    private String description;

    private Double weight;

    private Boolean controlled;

    private Integer minimumAmount;

//    private List<ProviderResponse> providerResponseList;
//
//    private String nameCategory;

}
