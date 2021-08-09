package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.application.util.MockitoExtension;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.model.CategoryProductEnum;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.repository.ProductRepository;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.ArgumentMatchers.any;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ImplRetrieveProductServiceTest {

    @InjectMocks
    private ImplRetrieveProductService implRetrieveProductService;

    @Mock
    private FindProductService findProductService;

    @Mock
    private ProductViewMapper productViewMapper;

    @BeforeEach
    void setup(){
        implRetrieveProductService = new ImplRetrieveProductService(productViewMapper, findProductService);
    }

    @Test
    void shouldReturnListOfProductViewsWhenReceiveListOfProducts(){
        // given
        ProductView p1View = new ProductView("Cheese", 2.0, CategoryProductEnum.FS.toString());

        Product p1 = new Product(Long.valueOf(1), "Cheese", 2.0, CategoryProductEnum.FS);

        List<ProductView> expect = new ArrayList();
        expect.add(p1View);

        // when
        when(findProductService.findAll()).thenReturn(List.of(p1));
        when(productViewMapper.map(any())).thenReturn(p1View);
        List<ProductView> result = implRetrieveProductService.retrieveProductViewList();

        // Then
        assertEquals(expect.get(0), result.get(0));
    }
}