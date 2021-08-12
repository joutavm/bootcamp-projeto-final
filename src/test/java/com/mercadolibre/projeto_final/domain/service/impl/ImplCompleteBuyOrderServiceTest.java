package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.dtos.mapper.BuyOrderCompletedMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderCompletedView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.*;
import com.mercadolibre.projeto_final.domain.service.BuyOrderService;
import com.mercadolibre.projeto_final.domain.service.FindProductInStockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ImplCompleteBuyOrderServiceTest {

    @Mock
    private BuyOrderService buyOrderService;
    @Mock
    private FindProductInStockService findProductInStockService;

    ImplCompleteBuyOrderService implCompleteBuyOrderService;

    @BeforeEach
    void setUp() {
        implCompleteBuyOrderService = new ImplCompleteBuyOrderService(buyOrderService, findProductInStockService,new BuyOrderCompletedMapper());
    }

    @Test
    void shouldReturnBuyOrderCompletedView_WhenPassingValidId(){
        //given
        CartItem cartItem1 = new CartItem(1L,14);
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem1);
        BuyOrder buyOrder = new BuyOrder(1L, LocalDate.now(),3L, BuyOrderStatusEnum.CR,cartItemList);
        Stock stock = new Stock();
        stock.setCurrentQuantity(200);


        //when
        when(buyOrderService.findBuyOrderById(any())).thenReturn(buyOrder);
        when(findProductInStockService.findProductInStock(any(),any())).thenReturn(stock);
        BuyOrderCompletedView result = implCompleteBuyOrderService.completeBuyOrder(1L);

        //then
        assertEquals(BuyOrderStatusEnum.CO.toString(),result.getOrderStatus());
        assertEquals("The purchase was successful! The items will be shipped to your house.",result.getValid());
    }

    @Test
    void shouldReturnException_WhenNoStockAvailable(){
        //given
        CartItem cartItem1 = new CartItem(1L,14);
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem1);
        BuyOrder buyOrder = new BuyOrder(1L, LocalDate.now(),3L, BuyOrderStatusEnum.CR,cartItemList);
        Stock stock = new Stock();
        stock.setCurrentQuantity(200);


        //when
        when(buyOrderService.findBuyOrderById(any())).thenReturn(buyOrder);
        when(findProductInStockService.findProductInStock(any(),any())).thenThrow(ItemNotFoundException.class);
        BuyOrderCompletedView result = implCompleteBuyOrderService.completeBuyOrder(1L);

        //then
        assertEquals(BuyOrderStatusEnum.FL.toString(),result.getOrderStatus());
        assertEquals("The items selected previously on your cart are not available anymore.,result.getValid());
    }


}
