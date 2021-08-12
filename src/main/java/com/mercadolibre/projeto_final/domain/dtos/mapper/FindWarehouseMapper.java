package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;
import com.mercadolibre.projeto_final.domain.model.Warehouse;
import org.springframework.stereotype.Component;

@Component
public class FindWarehouseMapper {

    public WarehouseStatisticsView map(Warehouse warehouse, double totalSize, int qtdStocks) {
        WarehouseStatisticsView view = new WarehouseStatisticsView();

        view.setId(warehouse.getId());
        view.setCode(warehouse.getCode());
        view.setQtdSection(warehouse.getSection().size());
        view.setTotalSize(totalSize);
        view.setTotalProducts(qtdStocks);

        return view;
    }

}
