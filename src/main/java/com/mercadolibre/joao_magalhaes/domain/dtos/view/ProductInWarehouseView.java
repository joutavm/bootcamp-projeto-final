package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductInWarehouseView {
    private String warehouseCode;
    private int totalQuantity;
}
