package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StockFormMapper {

    public Stock map(StockForm stockForm, Product product){
        return new Stock(stockForm.getNumber(),
                product,
                stockForm.getCurrentTemperature(),
                stockForm.getMinimumTemperature(),
                stockForm.getInitialQuantity(),
                stockForm.getCurrentQuantity(),
                LocalDate.parse(stockForm.getManufacturingDate()),
                LocalDateTime.parse(stockForm.getManufacturingTime()),
                LocalDate.parse(stockForm.getDueDate()));
    }
}
