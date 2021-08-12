package com.mercadolibre.projeto_final.domain.dtos.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class OverDueView {

    @JsonProperty("deleted_quantity")
    private final Long DeletedQuantity;
}
