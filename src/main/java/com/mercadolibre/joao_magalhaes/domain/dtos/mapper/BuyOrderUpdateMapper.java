package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.joao_magalhaes.domain.model.CartItem;
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