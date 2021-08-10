package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class StockView {

    private Long number;
    private String productId;
    private float currentTemperature;
    private float minimumTemperature;
    private int initialQuantity;
    private int currentQuantity;
    private String manufacturingDate;
    private String manufacturingTime;
    private String dueDate;

    public StockView(Long number, String productId, float currentTemperature, float minimumTemperature, int initialQuantity, int currentQuantity, String manufacturingDate, String manufacturingTime, String dueDate) {
        this.number = number;
        this.productId = productId;
        this.currentTemperature = currentTemperature;
        this.minimumTemperature = minimumTemperature;
        this.initialQuantity = initialQuantity;
        this.currentQuantity = currentQuantity;
        this.manufacturingDate = manufacturingDate;
        this.manufacturingTime = manufacturingTime;
        this.dueDate = dueDate;
    }
}