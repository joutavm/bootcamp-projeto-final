package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.projeto_final.domain.dtos.mapper.BuyOrderUpdateMapper;
import com.mercadolibre.projeto_final.domain.exceptions.OrderNotUpdatedException;
import com.mercadolibre.projeto_final.domain.service.FindBuyOrderById;
import com.mercadolibre.projeto_final.domain.service.FindProductInStockService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ImplUpdateOrderServiceTest {

    @Mock
    private FindBuyOrderById findBuyOrderById;
    @Mock
    private BuyOrderUpdateMapper buyOrderUpdateMapper;
    @Mock
    private FindProductInStockService findProductInStockService;

    @InjectMocks
    private ImplUpdateOrderService implUpdateOrderService;

    @BeforeEach
    void setUp(){
        implUpdateOrderService = new ImplUpdateOrderService(findBuyOrderById,buyOrderUpdateMapper,findProductInStockService);
    }

    @Test
    void shouldUpdateOrder_WhenPassingBuyerIdAndBuyForm(){
        //given
        BuyProductsForm buyProductsForm1 = new BuyProductsForm(1L,14);
        BuyProductsForm buyProductsForm2 = new BuyProductsForm(2L,10);
        List<BuyProductsForm> buyProductsFormList = new ArrayList<>();
        buyProductsFormList.add(buyProductsForm1);
        buyProductsFormList.add(buyProductsForm2);
        BuyOrderForm buyOrderForm = new BuyOrderForm(1L,buyProductsFormList);


        //when
        implUpdateOrderService.updateOrder(1L,buyOrderForm);
        verify(buyOrderUpdateMapper,times(1)).map(any(),any());

    }

    @Test
    void shouldThrowException_WhenProductNotAvailableInStock(){
        //given
        BuyProductsForm buyProductsForm1 = new BuyProductsForm(5L,14);
        BuyProductsForm buyProductsForm2 = new BuyProductsForm(7L,10);
        List<BuyProductsForm> buyProductsFormList = new ArrayList<>();
        buyProductsFormList.add(buyProductsForm1);
        buyProductsFormList.add(buyProductsForm2);
        BuyOrderForm buyOrderForm = new BuyOrderForm(1L,buyProductsFormList);

        //when
        when(findProductInStockService.findProductInStock(any())).thenThrow(new OrderNotUpdatedException("400","Order not updated", 400));

        //then
        assertThrows(OrderNotUpdatedException.class, () -> implUpdateOrderService.updateOrder(1L,buyOrderForm));

    }
}
