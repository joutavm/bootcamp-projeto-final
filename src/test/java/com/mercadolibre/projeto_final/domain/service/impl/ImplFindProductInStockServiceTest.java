package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.CategoryProductEnum;
import com.mercadolibre.projeto_final.domain.model.Product;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplFindProductInStockServiceTest {

    @Mock
    StockRepostitory stockRepostitory;

    ImplFindProductInStockService implFindProductInStockService;

    @BeforeEach
    void setUp() {
        implFindProductInStockService = new ImplFindProductInStockService(stockRepostitory);
    }

    @Test
    public void shouldReturnStockWhenProductIsInStock(){
        //given
        Product product = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProductEnum.FS);

        Stock expect = new Stock(1L, product,
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));

        List<Stock> stockList = new ArrayList<>();
        stockList.add(expect);

        BuyProductsForm buyProductsForm = new BuyProductsForm(1L, 5);

        //when
        when(stockRepostitory.findStocksWhereIdMatchesOrderAsc(any())).thenReturn(stockList);
        Stock result = implFindProductInStockService.findProductInStock(buyProductsForm);

        //then
        assertEquals(expect, result);
    }

    @Test
    void shouldThrowExceptionWhenProductNotInStocks(){
        // given
        Product product = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProductEnum.FS);

        Stock stock = new Stock(1L, product,
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));

        List<Stock> stockList = new ArrayList<>();

        BuyProductsForm buyProductsForm = new BuyProductsForm(1L, 50);

        //when
        when(stockRepostitory.findStocksWhereIdMatchesOrderAsc(any())).thenReturn(stockList);

        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindProductInStockService.findProductInStock(buyProductsForm));
    }

    @Test
    void shouldThrowExceptionWhenStockNotHaveEnoughQuantity(){
        // given
        Product product = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProductEnum.FS);

        Stock stock = new Stock(1L, product,
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));

        List<Stock> stockList = new ArrayList<>();
        stockList.add(stock);

        BuyProductsForm buyProductsForm = new BuyProductsForm(1L, 50);

        //when
        when(stockRepostitory.findStocksWhereIdMatchesOrderAsc(any())).thenReturn(stockList);

        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindProductInStockService.findProductInStock(buyProductsForm));
    }
}