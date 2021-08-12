package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.view.OverDueView;
import com.mercadolibre.projeto_final.domain.service.OverDueService;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@RequiredArgsConstructor
public class ImplOverDueService implements OverDueService {

    private final StockService stockService;


    @Override
    public OverDueView deleteAll() {
        Long numberDeletedItems = stockService.deleteAllByDueDateBefore(LocalDate.now());
        return new OverDueView(numberDeletedItems);
    }
}
