package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CityRequest {

    @NotBlank(message = "Informe a cidade!")
    private String name;

    @Size(max = 2)
    @NotBlank(message = "Informe a UF!")
    private String uf;

}
