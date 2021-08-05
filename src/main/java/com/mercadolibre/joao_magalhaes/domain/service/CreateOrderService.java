package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;

import java.util.List;

public interface CreateOrderService {

    InboundOrder create(InboundOrderForm form);
}