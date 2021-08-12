package com.mercadolibre.projeto_final.domain.service.impl;


import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StockService {

    private final StockRepostitory stockRepostitory;

    public List<Stock> findByDueDate(LocalDate date) {

        List<Stock> stockList = stockRepostitory.findAllByDueDateLessThanEqual(date);
        if(stockList.isEmpty()){
            throw new ItemNotFoundException("Not Content", "Zero stocks found with that due date!", 204);
        }
        return stockList;
    }

    @Transactional
    public Long deleteAllByDueDateBefore(LocalDate date){
        Long deletedItems = stockRepostitory.deleteAllByDueDateBefore(date);
        if (deletedItems == 0)
            throw new ItemNotFoundException("Not Content", "There aren't any overdue stock", 204);
        return deletedItems;

    }


}
