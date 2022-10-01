package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ConveyorRequest {

    @NotBlank(message = "Informe a tranportadora!")
    private String name;

    @NotBlank(message = "Informe o endereço!")
    private String address;

    @NotBlank(message = "Informe o número!")
    private Integer number;

    @NotBlank(message = "Informe o bairro!")
    private String district;

    @Size(max = 9)
    @NotBlank(message = "Informe o CEP!")
    private String zipCode;

    @Size(max = 18)
    @CNPJ(message = "CNPJ inválido. Informe-o corretamente!")
    @NotBlank(message = "Informe o CNPJ!")
    private String cnpj;

    @NotBlank(message = "Informe a inscrição!")
    private String subscription;

    @NotBlank(message = "Informe o contato!")
    private String contact;

    @Size(max = 15)
    @NotBlank(message = "Informe o telefone!")
    private String telephone;

}
