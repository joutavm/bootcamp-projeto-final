package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrderStatusEnum;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BuyOrderFormMapper {

    public BuyOrder map(BuyOrderForm source){
        BuyOrder buyOrder = new BuyOrder();
        buyOrder.setOrderStatus(BuyOrderStatusEnum.CR);
        buyOrder.setDate(LocalDate.now());
        buyOrder.setBuyerId(source.getBuyerId());
        //buyOrder.setProduct();

        return buyOrder;
    }
}