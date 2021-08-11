package com.mercadolibre.projeto_final.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrderProductsView {

   private Long productId;
   private Integer quantity;

}