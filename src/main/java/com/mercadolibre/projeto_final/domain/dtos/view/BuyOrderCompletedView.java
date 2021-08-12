package com.mercadolibre.projeto_final.domain.dtos.view;

import com.mercadolibre.projeto_final.domain.model.CartItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BuyOrderCompletedView {

    private String buyOrderId;
    private String orderStatus;
    private String orderDate;
    private List<CartItem> cartItemList;
    private String valid;
}
