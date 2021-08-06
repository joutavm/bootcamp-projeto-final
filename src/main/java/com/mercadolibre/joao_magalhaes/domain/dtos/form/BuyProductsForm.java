package com.mercadolibre.joao_magalhaes.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class BuyProductsForm {

    @NotNull
    @JsonProperty("productId")
    private Long productId;

    @NotNull
    @JsonProperty("quantity")
    private Integer quantity;

}