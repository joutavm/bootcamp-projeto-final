package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.application.util.MockitoExtension;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.CategoryProductEnum;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.repository.ProductRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplFindProductTest {

    @InjectMocks
    private ImplFindProduct implFindProduct;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductViewMapper productViewMapper;

    @BeforeEach
    void setup(){
        implFindProduct = new ImplFindProduct(productRepository, productViewMapper);
    }

    @Test
    void shouldReturnProductByIdWhenProductExists(){
        // given
        Product expect = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProductEnum.FS);

        // when
        when(productRepository.findById(any())).thenReturn(Optional.of(expect));
        Product result = implFindProduct.findById(1L);

        // Then
        assertEquals(expect, result);
    }

    @Test
    void shouldThrowExceptionWhenProductNotExists(){
        // given

        // when
        when(productRepository.findById(any())).thenReturn(Optional.empty());

        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindProduct.findById(1L));
    }

    @Test
    void shouldReturnListOfProductsWhenThereIsAtLeastOneProduct(){
        // given
        Product p1 = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProductEnum.FS);

        ProductView p1View = new ProductView("Cheese", 2.0, CategoryProductEnum.FS.toString());

        List<ProductView> expect = new ArrayList();
        expect.add(p1View);

        // when
        when(productRepository.findAll()).thenReturn(List.of(p1));
        when(productViewMapper.map(any())).thenReturn(p1View);
        List<ProductView> result = implFindProduct.findAll();

        // Then
        assertEquals(expect.get(0), result.get(0));
    }

    @Test
    void shouldExceptionWhenThereIsntProducts(){
        // given
        List<Product> productList = new ArrayList<>();

        // when
        when(productRepository.findAll()).thenReturn(productList);

        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindProduct.findAll());
    }

}