package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class StockServiceTest {

    private StockService stockService;
    @Mock
    private StockRepostitory stockRepostitory;

    @BeforeEach
    void setUp() {
        stockService = new StockService(stockRepostitory);
    }

    @Test
    void shouldReturnStockListWhenPassValidDate(){
        // given
        LocalDate date = LocalDate.now();
        List<Stock> stockList = List.of(new Stock());

        // when
        when(stockRepostitory.findAllByDueDateLessThanEqual(date)).thenReturn(stockList);

        // then
        assertEquals(stockList, stockService.findByDueDate(date));
    }

    @Test
    void shouldThrowExpectionWhenPassInvalidDate(){
        // given
        LocalDate date = LocalDate.now();
        List<Stock> stockList = new ArrayList<>();

        // when
        when(stockRepostitory.findAllByDueDateLessThanEqual(date)).thenReturn(stockList);

        // then
        assertThrows(ItemNotFoundException.class, () -> stockService.findByDueDate(date));
    }

    @Test
    void shouldReturnNumberDeletedItemsWhenPassValidDate(){
        // given
        Long expect = 5L;
        LocalDate date = LocalDate.now();


        // when
        when(stockRepostitory.deleteAllByDueDateBefore(any())).thenReturn(expect);

        // then
        assertEquals(expect, stockService.deleteAllByDueDateBefore(date));
    }

    @Test
    void shouldThrowExpectionWhenPassDateWithouOverDue(){
        // given
        LocalDate date = LocalDate.now();

        // when
        when(stockRepostitory.deleteAllByDueDateBefore(date)).thenReturn(0L);

        // then
        assertThrows(ItemNotFoundException.class, () -> stockService.findByDueDate(date));
    }
}