package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.form.PutInboundForm;
import com.mercadolibre.projeto_final.domain.model.InboundOrder;
import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.model.Stock;
import org.springframework.stereotype.Component;

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