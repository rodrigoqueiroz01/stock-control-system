package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ProductRequest {

    @NotBlank(message = "Informe a descrição!")
    private String description;

    @NotBlank(message = "Informe o peso!")
    private Double weight;

    private Boolean controlled;

    @NotBlank(message = "Informe a quantidade mínima!")
    private Integer minimumAmount;

}
