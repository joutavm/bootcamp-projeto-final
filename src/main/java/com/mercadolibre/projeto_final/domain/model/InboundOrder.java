package com.mercadolibre.projeto_final.domain.model;

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
    private LocalDate orderDate;
    @ManyToOne
    private Section section;
    @OneToMany(mappedBy = "inboundOrder", cascade = CascadeType.ALL)
    private List<Stock> stockList;

    public InboundOrder(LocalDate orderDate, Section section, List<Stock> stockList) {
        this.orderDate = orderDate;
        this.section = section;
        this.stockList = stockList;
    }
    public InboundOrder(Long orderNumber, LocalDate orderDate, Section section, List<Stock> stockList) {
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.section = section;
        this.stockList = stockList;
    }
}