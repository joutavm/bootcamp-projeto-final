package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.repository.BuyOrderRepository;
import com.mercadolibre.joao_magalhaes.domain.service.FindBuyOrderById;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImplFindBuyOrderById implements FindBuyOrderById {

    private final BuyOrderRepository buyOrderRepository;

    @Override
    public BuyOrder findById(Long orderId){
        return buyOrderRepository
                .findById(orderId)
                .orElseThrow(() -> new ItemNotFoundException("Not Found", "Order not found.", 404));
    }
}