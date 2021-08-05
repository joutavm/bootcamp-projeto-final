package com.mercadolibre.joao_magalhaes.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Section {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private double size;
    @ManyToOne
    private Warehouse warehouse;

  public Section(String code, double size, Warehouse warehouse) {
        this.code = code;
        this.size = size;
        this.warehouse = warehouse;
    }
}