package com.mercadolibre.projeto_final.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseStatisticsView {
    private Long id;
    private String code;
    private int qtdSection;
    private double totalSize;
    private int totalProducts;
}
