package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.mapper.DueDateMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;
import com.mercadolibre.projeto_final.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.projeto_final.domain.exceptions.ApiException;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import com.mercadolibre.projeto_final.domain.service.DueDateService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ImplDueDate implements DueDateService {

    private final StockRepostitory stockRepostitory;
    private final DueDateMapper dueDateMapper;

    @Override
    public List<DueDateView> findByDueDate(int days) {
        LocalDate date = convertDays(days);
        List<Stock> stockList = stockRepostitory.findByDueDate(date);
        if(stockList.isEmpty()){
            throw new ItemNotFoundException("Not Found", "Zero stocks found with that due date!", 404);
        }

        return stockList.stream().map(e -> dueDateMapper.map(e)).collect(Collectors.toList());
    }

    private void validateDays(int days){
        if(days<0){
            throw new ApiException("BAD REQUEST", "Days can't be negative!", 403);
        }
    }

    private LocalDate convertDays(int days){
        validateDays(days);
        return LocalDate.now().plusDays(days);
    }

}
