package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.PutStockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class StockFormMapperTest {

    @Test
    public void shouldReturnTheSameStockInfo(){
        Product product = new Product(1L, "Cheese");

         StockForm form = new StockForm(1L, 1L,
                12.5f, 12.5f,
                12, 12,
                "12-03-2021", "12-03-2021 12:30", "12-03-2021");
        Stock stock = new Stock(1L, new Product(1L, "Cheese"),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));
        StockFormMapper stockFormMapper = new StockFormMapper();
        
        assertEquals(stock.getManufacturingTime(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getManufacturingTime());
        assertEquals(stock.getManufacturingDate(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getManufacturingDate());
        assertEquals(stock.getMinimumTemperature(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getMinimumTemperature());
        assertEquals(stock.getCurrentQuantity(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getCurrentQuantity());
        assertEquals(stock.getCurrentTemperature(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getCurrentTemperature());
        assertEquals(stock.getInitialQuantity(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getInitialQuantity());
        assertEquals(stock.getInitialQuantity(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getInitialQuantity());
        assertEquals(stock.getDueDate(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getDueDate());

        assertEquals(stock.getProduct().getName(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getProduct().getName());
        assertEquals(stock.getProduct().getId(), stockFormMapper.updateStockByStockFormAndProduct(form, product).getProduct().getId());
    }

    @Test
    public void shouldUpdateStock_whenGivenStockPutStockFormAndProduct(){
        //given
        Product product = new Product(1L, "Cheese");
        Stock stock = new Stock(1L, new Product(1L, "Cheese"),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));
        PutStockForm putStockForm = new PutStockForm(1L,
                3L,
                12F,
                10F,
                10,
                12,
                "05-05-2020",
                "05-05-2020 10:00",
                "05-05-2020");
        StockFormMapper stockFormMapper = new StockFormMapper();

        //when
        stockFormMapper.updateStockByStockFormAndProduct(stock,putStockForm,product);

        //then
        assertEquals(stock.getNumber(),putStockForm.getNumber());
    }
}