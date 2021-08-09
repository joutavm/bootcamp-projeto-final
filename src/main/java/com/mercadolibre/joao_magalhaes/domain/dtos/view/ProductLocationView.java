package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import java.time.LocalDate;

public class ProductLocationView {
    private String sectionCode;
    private String warehouseCode;
    private Long productId;
    private int batchNumber;
    private int currentQuantity;
    private LocalDate dueDate;
}
