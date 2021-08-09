package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.exceptions.OrderNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;

public interface FindOrderService {
    InboundOrder findById(Long id) throws OrderNotFoundException;
}