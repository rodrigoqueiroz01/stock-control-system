package stock.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ProviderRequest {

    @NotBlank(message = "Informe o fornecedor!")
    private String provider;

    @NotBlank(message = "Informe o endereço!")
    private String address;

    @NotBlank(message = "Informe o número!")
    private Integer number;

    @NotBlank(message = "Informe o bairro!")
    private String district;

    @NotBlank(message = "Informe o CEP!")
    private String cep;

    @NotBlank(message = "Informe o contato!")
    private String contact;

    @CNPJ(message = "CNPJ inválido. Informe-o corretamente!")
    @NotBlank(message = "Informe o CNPJ!")
    private String cnpj;

    @NotBlank(message = "Informe a inscrição!")
    private String subscription;

    @NotBlank(message = "Informe o telefone!")
    private String telephone;

}
