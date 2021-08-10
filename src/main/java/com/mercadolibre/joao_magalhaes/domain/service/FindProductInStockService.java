package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;

public interface FindProductInStockService {
    Stock findProductInStock(BuyProductsForm buyProductsForm);
}