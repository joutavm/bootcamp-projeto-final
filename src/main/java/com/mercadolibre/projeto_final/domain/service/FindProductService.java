package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Product;

import java.util.List;

public interface FindProductService {

    List<Product> findAll();

    Product findById(Long id) throws ItemNotFoundException;

    List<ProductView> findAllProductsByCategory(String category);
}
