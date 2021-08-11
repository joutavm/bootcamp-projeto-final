package com.mercadolibre.projeto_final.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DueDateView {
    private int batchNumber;
    private String productId;
    private String category;
    private String dueDate;
    private int quantity;
    private String section;
    private String warehouse;
}
