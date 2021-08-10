package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.projeto_final.domain.model.CartItem;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BuyOrderUpdateMapper {

    public void map(BuyOrder buyOrder, BuyOrderForm buyOrderForm) {
        buyOrder.setOrderStatus(BuyOrderStatusEnum.CR);
        List<CartItem> cartItemList = new ArrayList<>();
        buyOrderForm.getProducts().forEach(item -> cartItemList.add(new CartItem(item.getProductId(),item.getQuantity())));
        buyOrder.setCartItems(cartItemList);
    }
}