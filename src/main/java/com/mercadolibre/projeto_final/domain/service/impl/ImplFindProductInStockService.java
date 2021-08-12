package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import com.mercadolibre.projeto_final.domain.service.FindProductInStockService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class ImplFindProductInStockService implements FindProductInStockService {

    private final StockRepostitory stockRepostitory;

    @Override
    public Stock findProductInStock(BuyProductsForm buyProductsForm) {
        for (Stock stock : stockRepostitory.findStocksWhereIdMatchesOrderAsc(buyProductsForm.getProductId())) {
            if(stock.getCurrentQuantity() >= buyProductsForm.getQuantity())
                return stock;
        }
        throw new ItemNotFoundException("404", "Stock Not found", 404);
    }

    @Override
    public Stock findProductInStock(Long id, Integer quantity) {
        for (Stock stock : stockRepostitory.findStocksWhereIdMatchesOrderAsc(id)) {
            if(stock.getCurrentQuantity() >= quantity)
                return stock;
        }
        throw new ItemNotFoundException("404", "Stock Not found", 404);
    }
}