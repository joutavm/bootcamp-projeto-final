package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.exceptions.OrderNotFoundException;
import com.mercadolibre.projeto_final.domain.model.InboundOrder;

public interface FindOrderService {
    InboundOrder findById(Long id) throws OrderNotFoundException;
}