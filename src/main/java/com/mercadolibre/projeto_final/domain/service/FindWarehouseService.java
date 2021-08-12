package com.mercadolibre.projeto_final.domain.service;


import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;

public interface FindWarehouseService {

    WarehouseStatisticsView warehouseStatistics(Long id);


}
