package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;

public interface UpdateOrderService {
    void updateOrder(Long buyOrderId, BuyOrderForm buyOrderForm);
}
