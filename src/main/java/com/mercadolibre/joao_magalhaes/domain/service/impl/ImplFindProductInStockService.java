package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.CartItem;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import com.mercadolibre.joao_magalhaes.domain.repository.StockRepostitory;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductInStockService;

import java.util.Optional;

public class ImplFindProductInStockService implements FindProductInStockService {

    StockRepostitory stockRepostitory;

    @Override
    public Stock findProductInStock(BuyProductsForm buyProductsForm) {
        //findStocks.forEach( item -> {
        // item.getQuantity <= buyProductsForm.getQuantity()
        //  return stock
        //estora execao se der errado
        // )
        Optional<Stock> stock = stockRepostitory.findAll().stream().filter(item ->{
            if(item.getProduct().getId().equals(buyProductsForm.getProductId())){
                if(item.getCurrentQuantity() >= buyProductsForm.getQuantity()){
                    return true;
                }
            }
            return false;
        }
        ).findFirst();

        return stock;
    }
}