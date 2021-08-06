package com.mercadolibre.joao_magalhaes.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BuyOrderForm {

    @NotNull
    @JsonProperty("buyerId")
    private Long buyerId;

    @NotNull
    @JsonProperty("orderStatus")
    private OrderStatusForm orderStatus;

    @NotNull
    @JsonProperty("products")
    private List<BuyProductsForm> products;
}