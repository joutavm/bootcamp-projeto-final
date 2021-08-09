package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
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