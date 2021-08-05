package com.mercadolibre.joao_magalhaes.domain.repository;

import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;

public interface OrderRepository {


    InboundOrder save(InboundOrder order);
}
