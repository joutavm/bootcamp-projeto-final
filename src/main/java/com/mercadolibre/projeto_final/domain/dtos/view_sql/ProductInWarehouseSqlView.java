package com.mercadolibre.projeto_final.domain.dtos.view_sql;

import com.mercadolibre.projeto_final.domain.model.Warehouse;
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

    public ProductInWarehouseSqlView(Long totalQuantity) {
        this.totalQuantity = totalQuantity;
    }
}
