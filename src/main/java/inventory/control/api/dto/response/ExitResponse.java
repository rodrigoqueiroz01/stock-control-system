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
public class ExitResponse {

    private UUID id;

    private Double total;

    private Double shipping;

    private Double tax;

//    private List<ConveyorResponse> conveyorResponseList;
//
//    private StoreResponse storeResponse;

}
