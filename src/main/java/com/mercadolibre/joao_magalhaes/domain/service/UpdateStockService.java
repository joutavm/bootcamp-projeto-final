package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;

public interface UpdateStockService {

    StockView update(String id, StockForm stockForm);
}
