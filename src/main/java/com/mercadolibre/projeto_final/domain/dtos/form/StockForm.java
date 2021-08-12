package com.mercadolibre.projeto_final.domain.dtos.form;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class StockForm {

    @NotEmpty @NotNull
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

    public StockForm(Long number, Long productId, Float currentTemperature, Float minimumTemperature, int initialQuantity, int currentQuantity, String manufacturingDate, String manufacturingTime, String dueDate) {
        this.productId = productId;
        this.currentTemperature = currentTemperature;
        this.minimumTemperature = minimumTemperature;
        this.initialQuantity = initialQuantity;
        this.currentQuantity = currentQuantity;
        this.manufacturingDate = manufacturingDate;
        this.manufacturingTime = manufacturingTime;
        this.dueDate = dueDate;
    }
}