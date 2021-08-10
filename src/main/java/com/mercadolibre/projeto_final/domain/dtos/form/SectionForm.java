package com.mercadolibre.projeto_final.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SectionForm {

    @NotNull
    @JsonProperty("sectionCode")
    private String sectionCode;

    @NotNull
    @JsonProperty("warehouseCode")
    private String warehouseCode;
}