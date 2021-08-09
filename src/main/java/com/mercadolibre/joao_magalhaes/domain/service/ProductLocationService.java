package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductLocationView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;

import java.util.List;

public interface ProductLocationService{
    public List<ProductLocationView> listById(Long id) throws ItemNotFoundException;
}
