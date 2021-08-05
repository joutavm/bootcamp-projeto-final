package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;

import java.util.List;
import java.util.stream.Collectors;

public class StockViewMapper{

    public StockView map(Stock source) {
        return new StockView(source.getNumber(),
                source.getProduct(),
                source.getCurrentTemperature(),
                source.getMinimumTemperature(),
                source.getInitialQuantity(),
                source.getCurrentQuantity(),
                source.getManufacturingDate(),
                source.getManufacturingTime(),
                source.getDueDate());
    }

    public List<StockView> mapOrderInStockList(InboundOrder inboundOrder) {
        return inboundOrder.getStockList().stream().map(this::map).collect(Collectors.toList());
    }
}