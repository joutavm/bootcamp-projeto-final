package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;

import java.time.LocalDate;
import java.util.List;

public class OrderFormMapper  {

    public InboundOrder map(InboundOrderForm source, List<Stock> stockList, Section section) {

        return new InboundOrder(LocalDate.parse(source.getOrderDate()), section, stockList);
    }
}
