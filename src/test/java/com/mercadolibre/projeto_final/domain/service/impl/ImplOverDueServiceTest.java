package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplOverDueServiceTest {

    private ImplOverDueService implOverDueService;

    @Mock
    private StockService stockService;

    @BeforeEach
    void setUp() {
        implOverDueService = new ImplOverDueService(stockService);
    }

    @Test
    void shouldReturnDtoWhenCallMethod() {
        // when
        when(stockService.deleteAllByDueDateBefore(any())).thenReturn(5L);
        var overDueView = implOverDueService.deleteAll();

        // then
        assertEquals(5L, overDueView.getDeletedQuantity());

    }
}