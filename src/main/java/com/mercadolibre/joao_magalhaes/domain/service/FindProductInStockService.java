package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.joao_magalhaes.domain.model.CartItem;

public interface FindProductInStockService {
    CartItem findProductInStock(BuyProductsForm buyProductsForm);
}