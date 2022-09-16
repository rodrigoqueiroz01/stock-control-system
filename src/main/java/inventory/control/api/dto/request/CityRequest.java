package inventory.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class CityRequest {

    @NotBlank(message = "Informe a cidade!")
    private String city;

    @NotBlank(message = "Informe a UF!")
    private String uf;

}
