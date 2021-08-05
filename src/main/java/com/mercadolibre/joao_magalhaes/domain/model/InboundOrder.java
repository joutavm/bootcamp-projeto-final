package com.mercadolibre.joao_magalhaes.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Setter
public class InboundOrder {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderNumber;
    private String orderDate;
    @ManyToOne
    private Section section;
    @OneToMany
    private List<Stock> stockList;

    public InboundOrder(Long orderNumber, String orderDate, Section section, List<Stock> stockList) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.section = section;
        this.stockList = stockList;
    }
}
