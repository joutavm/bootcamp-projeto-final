package com.mercadolibre.projeto_final.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductLocationView {
    private String sectionCode;
    private String warehouseCode;
    private Long productId;
    private Long batchNumber;
    private int currentQuantity;
    private String dueDate;
}
