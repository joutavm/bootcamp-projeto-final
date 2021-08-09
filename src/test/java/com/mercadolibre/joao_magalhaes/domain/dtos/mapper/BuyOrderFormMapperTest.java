package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.joao_magalhaes.domain.model.CartItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOrderFormMapperTest {

    private final BuyOrderFormMapper buyOrderFormMapper = new BuyOrderFormMapper();


    @Test
    void shoudCreateMapWhenTransformValuesToBuyOrder(){
        //Given
        List<BuyProductsForm> productsList = new ArrayList<>();
        productsList.add(new BuyProductsForm(1L, 10));
        productsList.add(new BuyProductsForm(2L, 5));
        BuyOrderForm buyOrderForm = new BuyOrderForm(
                1L, productsList
        );
        HashMap<Long, String> validatedProductsInStock = new HashMap<>();
        validatedProductsInStock.put(1L, "Success");
        validatedProductsInStock.put(2L, "Success");

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem(1L, 10));
        cartItems.add(new CartItem(2L, 5));
        BuyOrder buyOrder = new BuyOrder(
                LocalDate.now(),
                1L,
                BuyOrderStatusEnum.CR,
                cartItems
        );

        //When
        BuyOrder retorno = buyOrderFormMapper.map(buyOrderForm, validatedProductsInStock);

        //Then
        assertEquals(buyOrder.getOrderStatus(), retorno.getOrderStatus());
        assertEquals(buyOrder.getBuyerId(), retorno.getBuyerId());
        assertEquals(buyOrder.getCartItems().contains(2), retorno.getCartItems().contains(2));
        assertEquals(buyOrder.getDate(), retorno.getDate());

    }
}