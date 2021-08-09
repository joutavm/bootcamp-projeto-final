package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class ProductLocationView {
    private String sectionCode;
    private String warehouseCode;
    private Long productId;
    private Long batchNumber;
    private int currentQuantity;
    private String dueDate;
}
