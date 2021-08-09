package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;

public interface FindBuyOrderById {
    BuyOrder findById(Long orderId);
}