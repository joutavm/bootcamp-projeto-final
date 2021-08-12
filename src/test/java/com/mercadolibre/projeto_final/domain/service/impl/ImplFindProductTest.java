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

        List<Product> expect = new ArrayList();
        expect.add(p1);

        // when
        when(productRepository.findAll()).thenReturn(List.of(p1));
        List<Product> result = implFindProduct.findAll();

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

    @Test
    void shouldReturnListProductViewWhenfindAllProductsByCategory() {
        // Given
        Product product = new Product(1L, "Cheese", 20.1, CategoryProductEnum.RF);
        ProductView productView = new ProductView("Cheese", 20.1, "Refrigerado");
        // When
        when(productRepository.findByCategory(any())).thenReturn(Optional.of(List.of(product, product)));
        when(productViewMapper.map(any())).thenReturn(productView);
        List<ProductView> result = implFindProduct.findAllProductsByCategory("RF");

        // Then
        assertEquals(product.getName(), result.get(0).getName());
        assertEquals(product.getPrice(), result.get(0).getPrice());
        assertEquals(product.getCategory().toString(), result.get(0).getCategory());
    }

    @Test
    void shouldReturnNotFoundWhenfindAllProductsByCategoryNotExist() {
        // Given
        // When
        when(productRepository.findByCategory(any())).thenReturn(Optional.of(List.of(new Product())));
        List<ProductView> result = implFindProduct.findAllProductsByCategory("RF");
        // Then
        assertThrows(ItemNotFoundException.class, () -> implFindProduct.findAll());
    }

}