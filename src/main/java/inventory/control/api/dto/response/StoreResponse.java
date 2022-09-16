package inventory.control.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreResponse {

    private UUID id;

    private String name;

    private String zipCode;

    private String address;

    private Integer number;

    private String district;

    private String telephone;

    private String subscription;

    private String cnpj;

//    private List<CityResponse> cityResponseList;

}
