package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;
import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.model.Warehouse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FindWarehouseMapper {

    public WarehouseStatisticsView map(Warehouse warehouse, List<Stock> stocks) {
        WarehouseStatisticsView view = new WarehouseStatisticsView();

        view.setId(warehouse.getId());
        view.setCode(warehouse.getCode());
        view.setQtdSection(warehouse.getSection().size());
        view.setTotalSize(warehouse.getSection().stream().mapToDouble(Section::getSize).sum());
        view.setTotalProducts(stocks.size());

        return view;
    }

}
