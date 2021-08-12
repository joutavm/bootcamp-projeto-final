package com.mercadolibre.projeto_final.domain.dtos.mapper;


import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderCompletedView;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import org.springframework.stereotype.Component;

@Component
public class BuyOrderCompletedMapper {

    public BuyOrderCompletedView map(BuyOrder buyOrder, String msg){
        BuyOrderCompletedView buyOrderCompletedView = new BuyOrderCompletedView();
        buyOrderCompletedView.setBuyOrderId(buyOrder.getBuyerId().toString());
        buyOrderCompletedView.setOrderDate(buyOrder.getDate().toString());
        buyOrderCompletedView.setOrderStatus(buyOrder.getOrderStatus().toString());
        buyOrderCompletedView.setCartItemList(buyOrder.getCartItems());
        buyOrderCompletedView.setValid(msg);

        return buyOrderCompletedView;
    }
}
