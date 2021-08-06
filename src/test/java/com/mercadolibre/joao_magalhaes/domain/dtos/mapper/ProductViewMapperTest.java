package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.model.CategoryProductEnum;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductViewMapperTest {
    private final ProductViewMapper productViewMapper = new ProductViewMapper();
    @Test
    void shouldReturnProductViewWhenCreateProductViewMapper() {
        //Given
        Product product = new Product();
        product.setId(1L);
        product.setName("Cheese");
        product.setPrice(233.9);
        product.setCategory(CategoryProductEnum.FF);

        //When
         ProductView result = productViewMapper.map(product);

        //Then
        assertEquals(product.getName(), result.getName());
        assertEquals(product.getPrice(), result.getPrice());
        assertEquals(product.getCategory().toString(), result.getCategory());
    }
}