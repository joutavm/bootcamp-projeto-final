package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.PutInboundForm;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Component
public class PutOrderFormMapper {
    public InboundOrder map(PutInboundForm source, List<Stock> stockList, Section section) {

        InboundOrder order = new InboundOrder();
        order.setSection(section);
        order.setStockList(stockList);
        return order;
    }
}