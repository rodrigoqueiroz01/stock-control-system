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
public class ConveyorResponse {

    private UUID id;

    private String conveyor;

    private String address;

    private Integer number;

    private String district;

    private String zipCode;

    private String cnpj;

    private String subscription;

    private String contact;

    private String telephone;

//    private List<CityResponse> cityResponseList;

}
