package com.mercadolibre.joao_magalhaes.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Warehouse {
    @Id
    private Long id;
    private String code;
    @OneToMany(mappedBy = "warehouse")
    private List<Section> section;

}