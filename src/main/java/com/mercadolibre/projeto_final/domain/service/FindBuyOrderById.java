package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.model.BuyOrder;

public interface FindBuyOrderById {
    BuyOrder findById(Long orderId);
}