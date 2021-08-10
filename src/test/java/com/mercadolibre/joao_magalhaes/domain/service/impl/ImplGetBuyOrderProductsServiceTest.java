package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.application.util.MockitoExtension;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderProductsMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.joao_magalhaes.domain.service.FindBuyOrderById;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ImplGetBuyOrderProductsServiceTest {

    @Mock
    private FindBuyOrderById findBuyOrderById;
    @Mock
    private BuyOrderProductsMapper buyOrderProductsMapper;

    @InjectMocks
    private ImplGetBuyOrderProducts implGetBuyOrderProducts;

    @BeforeEach
    void setUp(){
        implGetBuyOrderProducts = new ImplGetBuyOrderProducts(findBuyOrderById,buyOrderProductsMapper);
    }

    @Test
    void whenPassingBuyingOrderId_ShouldReturnBuyOrderProductsViewList(){
        //given
        Long buyOrderId = 1L;
        BuyOrderProductsView buyOrderProductsView1 = new BuyOrderProductsView(1L,14);
        BuyOrderProductsView buyOrderProductsView2 = new BuyOrderProductsView(2L,15);
        List<BuyOrderProductsView> buyOrderProductsViewList = new ArrayList<>();
        buyOrderProductsViewList.add(buyOrderProductsView1);
        buyOrderProductsViewList.add(buyOrderProductsView2);

        //when
        when(buyOrderProductsMapper.map(findBuyOrderById.findById(buyOrderId))).thenReturn(buyOrderProductsViewList);
        List<BuyOrderProductsView> result =  implGetBuyOrderProducts.getProducts(buyOrderId);

        //then
        Assertions.assertEquals(result,buyOrderProductsViewList);
    }

}
