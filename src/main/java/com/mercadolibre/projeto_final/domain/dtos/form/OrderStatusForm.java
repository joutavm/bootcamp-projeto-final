package com.mercadolibre.projeto_final.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class OrderStatusForm {

    @NotNull
    @JsonProperty("statusCode")
    private String statusCode;

}