package stock.control.api.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.UUID;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProviderResponse {

    private UUID id;

    private String name;

    private String address;

    private Integer number;

    private String district;

    private String cep;

    private String contact;

    private String cnpj;

    private String subscription;

    private String telephone;

}
