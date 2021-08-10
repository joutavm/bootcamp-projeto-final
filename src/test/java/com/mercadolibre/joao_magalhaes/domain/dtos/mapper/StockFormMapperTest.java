package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.PutStockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.model.CategoryProductEnum;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StockFormMapperTest {

    private final StockFormMapper stockFormMapper = new StockFormMapper();

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

//        assertEquals(stock.getNumber(), stockFormMapper.map(form, product).getNumber());
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
    public void updateStockByStockFormAndProduct_GivenStockPutStockFormProduct(){
        //Given
        Product product = new Product(1L, "Cheese", 2.0, CategoryProductEnum.FS);
        PutStockForm putStockForm = new PutStockForm(1L, 1L, 12.5f,
                12.5f, 12, 12,
                LocalDate.of(2021, 10, 10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                LocalDateTime.of(2021, 10,10,10,10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")),
                LocalDate.of(2021,10,10).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));

        Stock stock = new Stock(1L, product,
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));

        //when
        stockFormMapper.updateStockByStockFormAndProduct(stock,putStockForm,product);

        //then
        assertEquals(stock.getCurrentTemperature(),putStockForm.getCurrentTemperature());
    }
}