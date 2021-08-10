package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.repository.BuyOrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ImplFindBuyOrderByIdTest {

    @Mock
    BuyOrderRepository buyOrderRepository;

    ImplFindBuyOrderById implFindBuyOrderById;

    @BeforeEach
    void setUp() {
        implFindBuyOrderById = new ImplFindBuyOrderById(buyOrderRepository);
    }

    @Test
    public void shouldReturnBuyOrderWhenBuyOrderExists(){
        //given
        BuyOrder expect = new BuyOrder();

        //when
        when(buyOrderRepository.findById(any())).thenReturn(Optional.of(expect));

        BuyOrder result = implFindBuyOrderById.findById(1L);
        //then
        assertEquals(expect, result);
    }

    @Test
    void shouldThrowExceptionWhenBuyOrderNotExists(){
        // given

        // when
        when(buyOrderRepository.findById(any())).thenReturn(Optional.empty());

        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindBuyOrderById.findById(1L));
    }
}