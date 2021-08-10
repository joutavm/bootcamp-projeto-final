package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.form.PutStockForm;
import com.mercadolibre.projeto_final.domain.dtos.form.StockForm;
import com.mercadolibre.projeto_final.domain.model.Product;
import com.mercadolibre.projeto_final.domain.model.Stock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class StockFormMapper {

    public Stock updateStockByStockFormAndProduct(StockForm stockForm, Product product){
        Stock stock = new Stock();
        stock.setProduct(product);
        stock.setCurrentQuantity(stockForm.getCurrentQuantity());
        stock.setCurrentTemperature(stockForm.getCurrentTemperature());
        stock.setMinimumTemperature(stockForm.getMinimumTemperature());
        stock.setInitialQuantity(stockForm.getInitialQuantity());
        stock.setCurrentTemperature(stockForm.getCurrentTemperature());
        stock.setManufacturingDate(LocalDate.parse(stockForm.getManufacturingDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        stock.setManufacturingTime(LocalDateTime.parse(stockForm.getManufacturingTime(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        stock.setDueDate(LocalDate.parse(stockForm.getDueDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        return stock;
    }

    public void updateStockByStockFormAndProduct(Stock stock, PutStockForm stockForm, Product produto){
        stock.setProduct(produto);
        stock.setCurrentQuantity(stockForm.getCurrentQuantity());
        stock.setCurrentTemperature(stockForm.getCurrentTemperature());
        stock.setMinimumTemperature(stockForm.getMinimumTemperature());
        stock.setInitialQuantity(stockForm.getInitialQuantity());
        stock.setCurrentTemperature(stockForm.getCurrentTemperature());
        stock.setManufacturingDate(LocalDate.parse(stockForm.getManufacturingDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        stock.setManufacturingTime(LocalDateTime.parse(stockForm.getManufacturingTime(), DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        stock.setDueDate(LocalDate.parse(stockForm.getDueDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

}