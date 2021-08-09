package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.CartItem;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import com.mercadolibre.joao_magalhaes.domain.repository.StockRepostitory;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductInStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;


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
}