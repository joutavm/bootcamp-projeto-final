package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.projeto_final.domain.model.CartItem;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuyOrderFormMapper {

    public BuyOrder map(BuyOrderForm source, HashMap<Long, String> products){
        BuyOrder buyOrder = new BuyOrder();
        buyOrder.setOrderStatus(BuyOrderStatusEnum.CR);
        buyOrder.setDate(LocalDate.now());
        buyOrder.setBuyerId(source.getBuyerId());
        buyOrder.setCartItems(getCartItemList(source, products));

        return buyOrder;
    }

    private List<CartItem> getCartItemList(BuyOrderForm source, HashMap<Long, String> products) {
       return source.getProducts().stream()
               .filter( item -> products.get(item.getProductId()).equals("success"))
               .map( item -> new CartItem(item.getProductId(), item.getQuantity()))
               .collect(Collectors.toList());
    }
}