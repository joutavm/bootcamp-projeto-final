package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BuyOrderProductsMapper {
    public List<BuyOrderProductsView> map(BuyOrder buyOrder) {
        return buyOrder.getCartItems().stream().map(item ->
            new BuyOrderProductsView(item.getProductId(), item.getQuantity())
        ).collect(Collectors.toList());
    }
}