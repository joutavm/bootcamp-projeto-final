package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductLocationView;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductWithIdWarehouseView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;

import java.util.List;

public interface ProductLocationService {
    public List<ProductLocationView> findByStockList(Long id) throws ItemNotFoundException;

    public List<ProductLocationView> findByStockSorted(Long id, Character order);

    public ProductWithIdWarehouseView findByWarehouse(Long id);
}
