package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.mapper.BuyOrderUpdateMapper;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.exceptions.OrderNotUpdatedException;
import com.mercadolibre.projeto_final.domain.service.FindBuyOrderById;
import com.mercadolibre.projeto_final.domain.service.FindProductInStockService;
import com.mercadolibre.projeto_final.domain.service.UpdateOrderService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;

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