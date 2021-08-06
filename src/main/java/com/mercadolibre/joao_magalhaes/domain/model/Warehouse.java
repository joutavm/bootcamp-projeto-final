package com.mercadolibre.joao_magalhaes.domain.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Warehouse {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    @OneToMany(mappedBy = "warehouse", cascade = CascadeType.ALL)
    private List<Section> section;

    public Warehouse(String code, List<Section> section) {
        this.code = code;
        this.section = section;
    }
}