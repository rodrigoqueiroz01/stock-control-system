package inventory.control.api.dto.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "Informe o login!")
    private String login;

    @NotBlank(message = "Informe a senha!")
    private String password;

}
