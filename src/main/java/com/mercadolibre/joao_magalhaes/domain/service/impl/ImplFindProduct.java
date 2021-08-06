package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.repository.ProductRepository;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ImplFindProduct implements FindProductService {

    private final ProductRepository productRepository;

    @Override
    public Product findById(Long id) {
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Not Found", "Product not found.", 404));
    }
}
