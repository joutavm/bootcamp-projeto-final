package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.exceptions.OrderNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Product;

public interface FindOrderService {
    InboundOrder findById(Long id) throws OrderNotFoundException;
}