package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderView;

public interface CreateBuyOrderService {

    BuyOrderView create(BuyOrderForm buyOrderForm);
}