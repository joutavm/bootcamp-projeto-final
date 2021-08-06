package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.Product;

import java.util.List;

public interface FindProductService {

    List<ProductView> findAll();

    Product findById(Long id) throws ItemNotFoundException;
}
