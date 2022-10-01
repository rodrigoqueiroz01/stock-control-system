package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class CategoryRequest {

    @NotBlank(message = "Informe o nome!")
    private String name;

}
