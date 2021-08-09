package com.mercadolibre.joao_magalhaes.domain.model;

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

}