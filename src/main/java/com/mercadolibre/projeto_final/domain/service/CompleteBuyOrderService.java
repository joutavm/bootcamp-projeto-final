package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderCompletedView;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderView;

public interface CompleteBuyOrderService {
    BuyOrderCompletedView completeBuyOrder(Long id);
}
