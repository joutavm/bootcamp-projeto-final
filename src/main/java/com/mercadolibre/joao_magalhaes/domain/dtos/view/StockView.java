package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import com.mercadolibre.joao_magalhaes.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class StockView {

    private Long number;
    private Product product;
    private Float currentTemperature;
    private Float minimumTemperature;
    private int initialQuantity;
    private int currentQuantity;
    private LocalDate manufacturingDate;
    private LocalDateTime manufacturingTime;
    private LocalDate dueDate;


}
