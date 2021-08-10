package com.mercadolibre.projeto_final.domain.dtos.view_sql;

import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.model.Stock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ProductLocationSqlView {
    private Section section;
    private Stock stock;

}
