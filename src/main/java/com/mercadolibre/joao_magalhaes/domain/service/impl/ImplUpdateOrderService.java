package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderProductsMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderUpdateMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.exceptions.OrderNotUpdatedException;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import com.mercadolibre.joao_magalhaes.domain.service.FindBuyOrderById;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductInStockService;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import com.mercadolibre.joao_magalhaes.domain.service.UpdateOrderService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class ImplUpdateOrderService implements UpdateOrderService {

    private final FindBuyOrderById findBuyOrderById;
    private final BuyOrderUpdateMapper buyOrderUpdateMapper;
    private final FindProductInStockService findProductInStockService;

    @Override @Transactional
    public void updateOrder(Long buyOrderId, BuyOrderForm buyOrderForm){
        buyOrderForm.getProducts().forEach(item -> {
            try {
                 findProductInStockService.findProductInStock(item);
            }catch(ItemNotFoundException e){
                throw new OrderNotUpdatedException("400","Order not updated", 400);
            }
        });
        buyOrderUpdateMapper.map(findBuyOrderById.findById(buyOrderId), buyOrderForm);
    }

}