package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.projeto_final.domain.model.CartItem;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


class BuyOrderProductsMapperTest {

    private final BuyOrderProductsMapper buyOrderProductsMapper = new BuyOrderProductsMapper();

    @Test
    void shouldReturnListOfBuyOrderProductsView_WhenPassingBuyOrder(){
        //given
        CartItem cartItem1 = new CartItem(1L,14);
        CartItem cartItem2 = new CartItem(2L,11);
        List<CartItem> cartItemList = new ArrayList<>();
        cartItemList.add(cartItem1);
        cartItemList.add(cartItem2);
        BuyOrder buyOrder = new BuyOrder(1L, LocalDate.now(),3L, BuyOrderStatusEnum.CR,cartItemList);
        BuyOrderProductsView buyOrderProductsView1 = new BuyOrderProductsView(1L,14);
        BuyOrderProductsView buyOrderProductsView2 = new BuyOrderProductsView(2L,11);
        List<BuyOrderProductsView> buyOrderProductsViewList = new ArrayList<>();
        buyOrderProductsViewList.add(buyOrderProductsView1);
        buyOrderProductsViewList.add(buyOrderProductsView2);

        //when
        List<BuyOrderProductsView> result = buyOrderProductsMapper.map(buyOrder);

        //then
        assertEquals(buyOrderProductsViewList.get(0).getProductId(), result.get(0).getProductId());
        assertEquals(buyOrderProductsViewList.get(0).getQuantity(), result.get(0).getQuantity());
        assertEquals(buyOrderProductsViewList.get(1).getProductId(), result.get(1).getProductId());
        assertEquals(buyOrderProductsViewList.get(1).getQuantity(), result.get(1).getQuantity());
    }
}
