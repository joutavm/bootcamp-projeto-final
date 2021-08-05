package com.mercadolibre.joao_magalhaes.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class InboundOrderForm {

    @NotNull
    private SectionFrom section;

    @JsonProperty("batch_stock")
    @NotNull
    private List<StockForm> batchStock;

    @JsonProperty("order_date")
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String orderDate;



}
