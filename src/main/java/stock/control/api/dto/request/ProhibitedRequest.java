package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProhibitedRequest {

    @NotBlank(message = "Informe a data de solicitação!")
    private LocalDateTime requestDate;

    @NotBlank(message = "Informe a data de entrada!")
    private LocalDateTime entryDate;

    @NotBlank(message = "Informe o valor!")
    private Double total;

    @NotBlank(message = "Informe o valor do frete!")
    private Double shipping;

    @NotBlank(message = "Informe o número da Nota Fiscal!")
    private Integer invoiceNumber;

    @NotBlank(message = "Informe o imposto!")
    private Double tax;

//    @NotBlank(message = "Informe o código da transportadora!")
//    private List<UUID> codConveyorList;

}
