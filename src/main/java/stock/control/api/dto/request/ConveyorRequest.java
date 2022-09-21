package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class ConveyorRequest {

    @NotBlank(message = "Informe a tranportadora!")
    private String conveyor;

    @NotBlank(message = "Informe o endereço!")
    private String address;

    @NotBlank(message = "Informe o número!")
    private Integer number;

    @NotBlank(message = "Informe o bairro!")
    private String district;

    @NotBlank(message = "Informe o CEP!")
    private String zipCode;

    @CNPJ(message = "CNPJ inválido. Informe-o corretamente!")
    @NotBlank(message = "Informe o CNPJ!")
    private String cnpj;

    @NotBlank(message = "Informe a inscrição!")
    private String subscription;

    @NotBlank(message = "Informe o contato!")
    private String contact;

    @NotBlank(message = "Informe o telefone!")
    private String telephone;

//    @NotBlank(message = "Informe o código da cidade!")
//    private List<UUID> codCityList;

}
