package inventory.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ExitRequest {

    @NotBlank(message = "Informe o valor total!")
    private Double total;

    @NotBlank(message = "Informe o valor do frete!")
    private Double shipping;

    @NotBlank(message = "Informe o valor do imposto!")
    private Double tax;

//    @NotBlank(message = "Informe o código da transportadora!")
//    private List<UUID> codConveyorList;
//
//    @NotBlank(message = "Informe o código da loja!")
//    private UUID codStore;

}
