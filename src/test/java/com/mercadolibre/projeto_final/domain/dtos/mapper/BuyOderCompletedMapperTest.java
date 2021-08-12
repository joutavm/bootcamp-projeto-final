package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderCompletedView;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.projeto_final.domain.model.CartItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOderCompletedMapperTest {

    private final BuyOrderCompletedMapper buyOrderCompletedMapper = new BuyOrderCompletedMapper();

    @Test
    void shouldReturnBuyOrderCompletedView_WhenPassingBuyOrderAndString(){
        //given
        String msg = "test";
        CartItem cartItem1 = new CartItem(1L,14);
        CartItem cartItem2 = new CartItem(2L,11);
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem1);
        cartItemList.add(cartItem2);
        BuyOrder buyOrder = new BuyOrder(1L, LocalDate.now(),3L, BuyOrderStatusEnum.CR,cartItemList);

        //when
        BuyOrderCompletedView map = buyOrderCompletedMapper.map(buyOrder, msg);

        //then
        assertEquals(map.getCartItemList().get(0).getProductId(),cartItem1.getProductId());
    }
}
