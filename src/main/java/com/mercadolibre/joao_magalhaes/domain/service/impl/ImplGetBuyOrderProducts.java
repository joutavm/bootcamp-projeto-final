package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderProductsMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.joao_magalhaes.domain.service.FindBuyOrderById;
import com.mercadolibre.joao_magalhaes.domain.service.GetBuyOrderProductsService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ImplGetBuyOrderProducts implements GetBuyOrderProductsService {

    private final FindBuyOrderById findBuyOrderById;
    private final BuyOrderProductsMapper buyOrderProductsMapper;

    @Override
    public List<BuyOrderProductsView> getProducts(Long buyOrderId) {
         return buyOrderProductsMapper.map(findBuyOrderById.findById(buyOrderId));
    }
}