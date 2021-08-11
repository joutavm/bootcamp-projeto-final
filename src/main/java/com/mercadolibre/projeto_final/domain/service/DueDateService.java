package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;

import java.util.List;

public interface DueDateService {
    List<DueDateView> findByDueDate(int days);

    List<DueDateView> findByDueDateSorted(int days, String category, String order);
}
