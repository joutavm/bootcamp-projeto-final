package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.application.util.MockitoExtension;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.repository.ProductRepository;
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
class ImplFindProductTest {

    private ImplFindProduct implFindProduct;

    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setUp(){
        implFindProduct = new ImplFindProduct(productRepository);
    }


    @Test
    void shouldFindProductWhenProductIdExist() {
        // given
        Product expect = new Product();


        // when
        when(productRepository.findById(any())).thenReturn(Optional.of(expect));
        Product result = implFindProduct.findById(1L);

        // Then
        assertEquals(expect, result);
    }

    @Test
    void shouldThorwExceptionWhenSectionCodeAndWarehouseCodeNotExist() {
        // given

        // when
        when(productRepository.findById(any())).thenReturn(Optional.empty());

        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindProduct.findById(1L));
    }

}