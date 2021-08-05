package com.mercadolibre.joao_magalhaes.domain.dtos.form;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
public class StockForm {

    @NotNull
    private Long number;

    @NotEmpty @NotNull
    private Long productId;

    @NotNull
    private Float currentTemperature;

    @NotNull
    private Float minimumTemperature;

    @NotNull
    private int initialQuantity;

    @NotNull
    private int currentQuantity;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String manufacturingDate;

    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    private String manufacturingTime;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String dueDate;
}
