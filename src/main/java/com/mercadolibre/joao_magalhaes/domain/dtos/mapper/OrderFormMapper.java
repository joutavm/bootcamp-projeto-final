package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class OrderFormMapper  {

    public InboundOrder map(InboundOrderForm source, List<Stock> stockList, Section section) {

        InboundOrder order = new InboundOrder();
        order.setOrderDate(LocalDate.parse(source.getOrderDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        order.setSection(section);
        stockList.forEach(e -> e.setInboundOrder(order)); // kenyo
        order.setStockList(stockList);
        return order;
    }
}