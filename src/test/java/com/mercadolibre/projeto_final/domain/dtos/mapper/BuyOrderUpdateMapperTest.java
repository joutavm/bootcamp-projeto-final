package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.projeto_final.domain.model.CartItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BuyOrderUpdateMapperTest {

    private final BuyOrderUpdateMapper buyOrderUpdateMapper = new BuyOrderUpdateMapper();
    @Test
    void shoudUpdateValuesInBuyOrderWhenABuyOrderFormIsGiven(){
        //Given
        List<BuyProductsForm> productsList = new ArrayList<>();
        productsList.add(new BuyProductsForm(1L, 10));
        productsList.add(new BuyProductsForm(2L, 5));
        BuyOrderForm buyOrderForm = new BuyOrderForm(
                1L, productsList
        );

        List<CartItem> cartItems = new ArrayList<>();
        cartItems.add(new CartItem(1L, 8));
        cartItems.add(new CartItem(2L, 5));
        BuyOrder buyOrder = new BuyOrder(
                LocalDate.now(),
                1L,
                BuyOrderStatusEnum.CR,
                cartItems
        );

        //When
         buyOrderUpdateMapper.map(buyOrder, buyOrderForm);

        //Then
        assertEquals(buyOrder.getCartItems().contains(2), buyOrderForm.getProducts().contains(2));
        assertEquals(buyOrder.getCartItems().get(0).getQuantity(), buyOrderForm.getProducts().get(0).getQuantity());
        assertEquals(buyOrder.getCartItems().get(1).getQuantity(), buyOrderForm.getProducts().get(1).getQuantity());
    }
}