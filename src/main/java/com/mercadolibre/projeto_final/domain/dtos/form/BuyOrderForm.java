package com.mercadolibre.projeto_final.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrderForm {

    @NotNull
    @JsonProperty("buyerId")
    private Long buyerId;

    @NotNull
    @JsonProperty("products")
    private List<BuyProductsForm> products;
}