package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import com.mercadolibre.joao_magalhaes.domain.model.CategoryProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@AllArgsConstructor
@Setter
@NoArgsConstructor
public class ProductView {
    private String name;
    private double price;
    private String category;
}
