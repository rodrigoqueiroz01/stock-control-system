package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Getter
@Setter
public class EntryItemRequest {

    @NotBlank(message = "Informe o lote!")
    private String batch;

    @NotBlank(message = "Informe a quantidade!")
    private Integer amount;

    @NotBlank(message = "Informe o valor!")
    private Double value;

//    @NotBlank(message = "Informe o código do produto!")
//    private UUID codProduct;

//    @NotBlank(message = "Informe o código de entrada!")
//    private UUID codProhibited;

}
