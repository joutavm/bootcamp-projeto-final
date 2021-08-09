package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderProductsMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderUpdateMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.service.FindBuyOrderById;
import com.mercadolibre.joao_magalhaes.domain.service.UpdateOrderService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
public class ImplUpdateOrderService implements UpdateOrderService {

    private final FindBuyOrderById findBuyOrderById;
    private final BuyOrderUpdateMapper buyOrderUpdateMapper;

    @Override @Transactional
    public void updateOrder(Long buyOrderId, BuyOrderForm buyOrderForm){
        buyOrderUpdateMapper.map(findBuyOrderById.findById(buyOrderId), buyOrderForm);
    }

}
