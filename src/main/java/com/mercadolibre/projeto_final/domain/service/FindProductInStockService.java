package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.projeto_final.domain.model.Stock;

public interface FindProductInStockService {
    Stock findProductInStock(BuyProductsForm buyProductsForm);
}