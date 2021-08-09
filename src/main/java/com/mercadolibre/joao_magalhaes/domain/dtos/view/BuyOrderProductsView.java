package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrderProductsView {

   private Long productId;
   private Integer quantity;

}