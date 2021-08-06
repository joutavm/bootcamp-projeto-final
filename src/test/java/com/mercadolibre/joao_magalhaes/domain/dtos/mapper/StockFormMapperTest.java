package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.model.CategoryProductEnum;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StockFormMapperTest {

    @Test
    public void shouldReturnTheSameStockInfo(){
        Product product = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProductEnum.FS);

         StockForm form = new StockForm(1L, Long.valueOf(1),
                12.5f, 12.5f,
                12, 12,
                "12-03-2021", "12-03-2021 12:30", "12-03-2021");
        Stock stock = new Stock(1L, new Product(1L, "Cheese", 2.0, CategoryProductEnum.FS),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));
        StockFormMapper stockFormMapper = new StockFormMapper();

        assertEquals(stock.getNumber(), stockFormMapper.map(form, product).getNumber());
        assertEquals(stock.getManufacturingTime(), stockFormMapper.map(form, product).getManufacturingTime());
        assertEquals(stock.getManufacturingDate(), stockFormMapper.map(form, product).getManufacturingDate());
        assertEquals(stock.getMinimumTemperature(), stockFormMapper.map(form, product).getMinimumTemperature());
        assertEquals(stock.getCurrentQuantity(), stockFormMapper.map(form, product).getCurrentQuantity());
        assertEquals(stock.getCurrentTemperature(), stockFormMapper.map(form, product).getCurrentTemperature());
        assertEquals(stock.getInitialQuantity(), stockFormMapper.map(form, product).getInitialQuantity());
        assertEquals(stock.getInitialQuantity(), stockFormMapper.map(form, product).getInitialQuantity());
        assertEquals(stock.getDueDate(), stockFormMapper.map(form, product).getDueDate());

        assertEquals(stock.getProduct().getName(), stockFormMapper.map(form, product).getProduct().getName());
        assertEquals(stock.getProduct().getId(), stockFormMapper.map(form, product).getProduct().getId());
    }
}