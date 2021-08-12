package com.mercadolibre.projeto_final.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Stock {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;
    @ManyToOne
    private Product product;
    private Float currentTemperature;
    private Float minimumTemperature;
    private int initialQuantity;
    private int currentQuantity;
    private LocalDate manufacturingDate;
    private LocalDateTime manufacturingTime;
    private LocalDate dueDate;
    @ManyToOne
    private InboundOrder inboundOrder;

    public Stock(Product product, InboundOrder inboundOrder) {
        this.product = product;
    }

    public Stock(Long number,
                 Product product,
                 Float currentTemperature,
                 Float minimumTemperature,
                 int initialQuantity,
                 int currentQuantity,
                 LocalDate manufacturingDate,
                 LocalDateTime manufacturingTime,
                 LocalDate dueDate) {
        this.number = number;
        this.product = product;
        this.currentTemperature = currentTemperature;
        this.minimumTemperature = minimumTemperature;
        this.initialQuantity = initialQuantity;
        this.currentQuantity = currentQuantity;
        this.manufacturingDate = manufacturingDate;
        this.manufacturingTime = manufacturingTime;
        this.dueDate = dueDate;
    }
}