package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductLocationView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.service.ProductLocationService;

import java.util.List;

public class ImplProductLocation implements ProductLocationService {

    @Override
    public List<ProductLocationView> listById(Long id) throws ItemNotFoundException {
        return null;
    }
}
