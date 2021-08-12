package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.repository.BuyOrderRepository;
import com.mercadolibre.projeto_final.domain.service.FindBuyOrderById;
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