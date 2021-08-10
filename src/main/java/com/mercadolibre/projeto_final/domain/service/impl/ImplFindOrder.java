package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.exceptions.OrderNotFoundException;
import com.mercadolibre.projeto_final.domain.model.InboundOrder;
import com.mercadolibre.projeto_final.domain.repository.OrderRepository;
import com.mercadolibre.projeto_final.domain.service.FindOrderService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ImplFindOrder implements FindOrderService {

    private final OrderRepository orderRepository;

    @Override
    public InboundOrder findById(Long id) {
        return orderRepository
                .findById(id)
                .orElseThrow(() -> new OrderNotFoundException("Not Found", "Order not found.", 404));
    }
}
