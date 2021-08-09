package com.mercadolibre.joao_magalhaes.domain.service;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;

public interface CreateBuyOrderService {

    BuyOrderView create(BuyOrderForm buyOrderForm);
}