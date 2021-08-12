package com.mercadolibre.projeto_final.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PutInboundForm {

    @NotNull
    @JsonProperty("orderNumber")
    private Long orderNumber;

    @NotNull
    @JsonProperty
    private SectionForm section;

    @JsonProperty("batch_stock")
    @NotNull
    private List<PutStockForm> batchStock;

}