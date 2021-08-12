package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.mapper.FindWarehouseMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.model.Warehouse;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import com.mercadolibre.projeto_final.domain.repository.WarehouseRepository;
import com.mercadolibre.projeto_final.domain.service.FindWarehouseService;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ImplFindWarehouseService implements FindWarehouseService {

    private final WarehouseRepository warehouseRepository;
    private final StockRepostitory stockRepostitory;
    private final FindWarehouseMapper findWarehouseMapper;


    @Override
    public WarehouseStatisticsView warehouseStatistics(Long id) {
        int qtdStocks;

        Warehouse warehouse = warehouseRepository
                .findById(id)
                .orElseThrow(() -> new ItemNotFoundException("Not Found", "Warehouse not was find", 404));

        List<Stock> stocks = stockRepostitory.findAllByInboundOrder_Section_Warehouse_Id(warehouse.getId());

        return findWarehouseMapper.map(warehouse, stocks);
    }
}
