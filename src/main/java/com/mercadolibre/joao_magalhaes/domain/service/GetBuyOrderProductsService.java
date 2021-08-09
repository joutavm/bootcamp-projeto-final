package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;

import java.util.List;

public interface GetBuyOrderProductsService {
    List<BuyOrderProductsView> getProducts(Long buyOrderId);
}