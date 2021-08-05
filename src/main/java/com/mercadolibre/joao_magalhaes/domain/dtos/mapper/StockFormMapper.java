package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StockFormMapper {

    public Stock map(StockForm stockForm, Product product){
        return new Stock(stockForm.getNumber(),
                product,
                stockForm.getCurrentTemperature(),
                stockForm.getMinimumTemperature(),
                stockForm.getInitialQuantity(),
                stockForm.getCurrentQuantity(),
                LocalDate.parse(stockForm.getManufacturingDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                LocalDateTime.parse(stockForm.getManufacturingTime(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                LocalDate.parse(stockForm.getDueDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }
}
