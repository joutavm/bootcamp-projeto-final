package com.mercadolibre.projeto_final.domain.dtos.view;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductWithIdWarehouseView {
    private Long productId;
    private List<ProductInWarehouseView> productInWarehouseViewList;
}
