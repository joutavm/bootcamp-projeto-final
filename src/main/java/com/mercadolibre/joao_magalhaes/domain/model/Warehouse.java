package com.mercadolibre.joao_magalhaes.domain.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Warehouse {
    @Id
    private String code;
    @OneToMany(mappedBy = "warehouse")
    private List<Section> section;

    public Warehouse(String code, List<Section> section) {
        this.code = code;
        this.section = section;
    }
}
