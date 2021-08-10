package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.form.PutInboundForm;
import com.mercadolibre.projeto_final.domain.dtos.view.StockView;

import java.util.List;

public interface UpdateStockService {

    List<StockView> update(PutInboundForm putInboundForm);
}