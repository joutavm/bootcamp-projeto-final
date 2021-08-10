package com.mercadolibre.joao_magalhaes.domain.dtos.view_sql;

import com.mercadolibre.joao_magalhaes.domain.model.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductInWarehouseSqlView {
    private Warehouse warehouse;
    private Long totalQuantity;
}
