package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;

import java.util.List;

public interface RetrieveProductService {
    public List<ProductView> retrieveProductViewList();
}
