package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;

import java.util.List;

public interface UpdateOrderService {
    void updateOrder(Long buyOrderId, BuyOrderForm buyOrderForm);
}
