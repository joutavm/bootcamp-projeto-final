package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;

import java.util.List;

public interface RetrieveProductService {
    public List<ProductView> retrieveProductViewList();

    List<ProductView> findAllSortedByPrice(String order);
}
