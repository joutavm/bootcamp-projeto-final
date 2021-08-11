package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;
import com.mercadolibre.projeto_final.domain.model.Stock;
import org.springframework.stereotype.Component;

import java.time.format.DateTimeFormatter;

@Component
public class DueDateMapper {
    public DueDateView map(Stock stock){
        DueDateView dueDateView = new DueDateView();
        dueDateView.setBatchNumber(stock.getNumber().intValue());
        dueDateView.setDueDate(stock.getDueDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        dueDateView.setCategory(stock.getProduct().getCategory().toString());
        dueDateView.setQuantity(stock.getCurrentQuantity());
        dueDateView.setProductId(stock.getProduct().getId().toString());
        dueDateView.setWarehouse(stock.getInboundOrder().getSection().getWarehouse().getCode());
        dueDateView.setSection(stock.getInboundOrder().getSection().getCode());

        return dueDateView;
    }
}
