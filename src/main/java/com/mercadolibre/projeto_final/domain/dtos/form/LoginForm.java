package com.mercadolibre.projeto_final.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Setter
@Getter
public class LoginForm {

    @NotNull @NotEmpty
    @JsonProperty("user_name")
    private String userName;
    @NotNull @NotEmpty
    private String password;

    public UsernamePasswordAuthenticationToken convert() {
        return new UsernamePasswordAuthenticationToken(userName, password);
    }
}
