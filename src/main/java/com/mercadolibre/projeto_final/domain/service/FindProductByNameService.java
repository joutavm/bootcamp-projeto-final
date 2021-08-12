package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;

public interface FindProductByNameService {

    ProductView findProductByName(String name);
}
