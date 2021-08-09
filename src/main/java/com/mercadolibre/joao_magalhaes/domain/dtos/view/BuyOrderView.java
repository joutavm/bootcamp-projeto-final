package com.mercadolibre.joao_magalhaes.domain.dtos.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrderView {

    private AtomicReference<Double> totalPrice;

    private HashMap<Long, String> returnView;

}