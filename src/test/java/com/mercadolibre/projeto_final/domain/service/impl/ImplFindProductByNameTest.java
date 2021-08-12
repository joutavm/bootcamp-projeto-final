package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.CategoryProductEnum;
import com.mercadolibre.projeto_final.domain.model.Product;
import com.mercadolibre.projeto_final.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplFindProductByNameTest {


    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductViewMapper productViewMapper;

    private ImplFindProductByName implFindProductByName;

    @BeforeEach
    void setup(){
        implFindProductByName = new ImplFindProductByName(productRepository, productViewMapper);
    }

    @Test
    void shouldReturnProductWhenProductExists(){
        //given
        Product product = new Product(Long.valueOf(1), "queijo", 2.0, CategoryProductEnum.FS);
        ProductView expect = new ProductView("queijo", 2.0, "Refrigerado");

        // When
        when(productRepository.findByName(any())).thenReturn(Optional.of(product));
        when(productViewMapper.map(any())).thenReturn(expect);

        ProductView result = implFindProductByName.findProductByName("queijo");
        //then
        assertEquals(expect, result);
    }

    @Test
    void shouldThrowExceptionWhenThereIsntProductsWithThatName(){
        // given

        // when
        when(productRepository.findAll()).thenReturn(new ArrayList<>());

        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindProductByName.findProductByName("queijo"));
    }
}