package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.dtos.mapper.ProductViewMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.model.CategoryProductEnum;
import com.mercadolibre.projeto_final.domain.model.Product;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
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

    @Test
    void shouldReturnListOfProductsOrderByPriceAscWhenThereAreProducts(){
        // given
        ImplRetrieveProductService implRetrieveProductServiceSpy = Mockito.spy(implRetrieveProductService);

        ProductView p1View = new ProductView("Queijo", 2.0, CategoryProductEnum.FS.toString());
        ProductView p2View = new ProductView("Pizza", 10.0, CategoryProductEnum.FS.toString());
        ProductView p3View = new ProductView("Presunto", 5.0, CategoryProductEnum.FS.toString());

        List<ProductView> expect = new ArrayList();
        expect.add(p1View);
        expect.add(p3View);
        expect.add(p2View);

        List<ProductView> productList = new ArrayList();
        productList.add(p1View);
        productList.add(p2View);
        productList.add(p3View);

        // when
        doReturn(productList).when(implRetrieveProductServiceSpy).retrieveProductViewList();
        List<ProductView> result = implRetrieveProductServiceSpy.findAllSortedByPrice("asc");

        // Then
        assertEquals(expect.get(0).getName(), result.get(0).getName());
        assertEquals(expect.get(1).getName(), result.get(1).getName());
        assertEquals(expect.get(2).getName(), result.get(2).getName());
    }

    @Test
    void shouldReturnListOfProductsOrderByPriceDescWhenThereAreProducts(){
        // given
        ImplRetrieveProductService implRetrieveProductServiceSpy = Mockito.spy(implRetrieveProductService);

        ProductView p1View = new ProductView("Queijo", 2.0, CategoryProductEnum.FS.toString());
        ProductView p2View = new ProductView("Pizza", 10.0, CategoryProductEnum.FS.toString());
        ProductView p3View = new ProductView("Presunto", 5.0, CategoryProductEnum.FS.toString());

        List<ProductView> expect = new ArrayList();
        expect.add(p2View);
        expect.add(p3View);
        expect.add(p1View);

        List<ProductView> productList = new ArrayList();
        productList.add(p1View);
        productList.add(p2View);
        productList.add(p3View);

        // when
        doReturn(productList).when(implRetrieveProductServiceSpy).retrieveProductViewList();
        List<ProductView> result = implRetrieveProductServiceSpy.findAllSortedByPrice("desc");

        // Then
        assertEquals(expect.get(0).getName(), result.get(0).getName());
        assertEquals(expect.get(1).getName(), result.get(1).getName());
        assertEquals(expect.get(2).getName(), result.get(2).getName());
    }
}