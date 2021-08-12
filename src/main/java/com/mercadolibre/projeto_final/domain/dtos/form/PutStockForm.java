package com.mercadolibre.projeto_final.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PutStockForm {

    @NotNull
    @NotEmpty
    @JsonProperty("number")
    private Long number;

    @NotEmpty
    @NotNull
    @JsonProperty("productId")
    private Long productId;
    @NotNull
    @JsonProperty("currentTemperature")
    private Float currentTemperature;
    @NotNull
    @JsonProperty("minimumTemperature")
    private Float minimumTemperature;
    @NotNull
    @JsonProperty("initialQuantity")
    private int initialQuantity;
    @NotNull
    @JsonProperty("currentQuantity")
    private int currentQuantity;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("manufacturingDate")
    private String manufacturingDate;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm")
    @JsonProperty("manufacturingTime")
    private String manufacturingTime;
    @NotNull
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("dueDate")
    private String dueDate;

}