package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ProductView {
    private String name;
    private double price;
    private String category;
}
