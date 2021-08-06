package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.exceptions.OrderNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.repository.OrderRepository;
import com.mercadolibre.joao_magalhaes.domain.service.FindOrderService;
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
