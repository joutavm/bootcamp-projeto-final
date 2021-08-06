package com.mercadolibre.joao_magalhaes.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    @Enumerated(EnumType.STRING)
    private CategoryProduct category;

    public Product(Long id, String name, double price, CategoryProduct category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }
}