package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.exceptions.OrderNotFoundException;
import com.mercadolibre.projeto_final.domain.model.InboundOrder;
import com.mercadolibre.projeto_final.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplFindOrderTest {

    private ImplFindOrder implFindOrder;

    @Mock
    private OrderRepository orderRepository;

    @BeforeEach
    void setUp(){
        implFindOrder = new ImplFindOrder(orderRepository);
    }


    @Test
    void shouldFindProductWhenProductIdExist() {
        // given
        InboundOrder expect = new InboundOrder();


        // when
        when(orderRepository.findById(any())).thenReturn(Optional.of(expect));
        InboundOrder result = implFindOrder.findById(1L);

        // Then
        assertEquals(expect, result);
    }

    @Test
    void shouldThorwExceptionWhenSectionCodeAndWarehouseCodeNotExist() {
        // given

        // when
        when(orderRepository.findById(any())).thenReturn(Optional.empty());

        // Then
        assertThrows(OrderNotFoundException.class, () -> implFindOrder.findById(1L));
    }

}