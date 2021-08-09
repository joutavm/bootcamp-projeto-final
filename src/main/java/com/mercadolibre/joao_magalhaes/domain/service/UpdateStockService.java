package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.PutInboundForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;

import java.util.List;

public interface UpdateStockService {

    List<StockView> update(PutInboundForm putInboundForm);
}