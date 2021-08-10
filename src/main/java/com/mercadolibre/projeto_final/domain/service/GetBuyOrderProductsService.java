package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderProductsView;

import java.util.List;

public interface GetBuyOrderProductsService {
    List<BuyOrderProductsView> getProducts(Long buyOrderId);
}