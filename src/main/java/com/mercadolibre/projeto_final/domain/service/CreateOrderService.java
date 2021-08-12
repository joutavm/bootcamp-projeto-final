package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.view.StockView;

import java.util.List;

public interface CreateOrderService {

    List<StockView> create(InboundOrderForm form);
}