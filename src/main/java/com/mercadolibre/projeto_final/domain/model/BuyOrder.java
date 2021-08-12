package com.mercadolibre.projeto_final.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
    private Long buyerId;
    @Enumerated(EnumType.STRING)
    private BuyOrderStatusEnum orderStatus;
    @OneToMany(cascade = CascadeType.ALL)
    private List<CartItem> cartItems;

    public BuyOrder(LocalDate date, Long buyerId, BuyOrderStatusEnum orderStatus, List<CartItem> cartItems) {
        this.date = date;
        this.buyerId = buyerId;
        this.orderStatus = orderStatus;
        this.cartItems = cartItems;
    }
}