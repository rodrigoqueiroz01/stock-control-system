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
public class OutputItemResponse {

    private UUID id;

    private String batch;

    private Integer amount;

    private Double value;

}
