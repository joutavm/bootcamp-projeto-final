package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.StockView;
import com.mercadolibre.projeto_final.domain.model.InboundOrder;
import com.mercadolibre.projeto_final.domain.model.Stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockViewMapper{

    public StockView map(Stock source) {
        return new StockView(source.getNumber(),
                source.getProduct().getId().toString(),
                source.getCurrentTemperature(),
                source.getMinimumTemperature(),
                source.getInitialQuantity(),
                source.getCurrentQuantity(),
                source.getManufacturingDate().toString(),
                source.getManufacturingTime().toString(),
                source.getDueDate().toString());
    }

    public List<StockView> mapOrderInStockList(InboundOrder inboundOrder) {
        return inboundOrder.getStockList().stream().map(this::map).collect(Collectors.toList());
    }
}