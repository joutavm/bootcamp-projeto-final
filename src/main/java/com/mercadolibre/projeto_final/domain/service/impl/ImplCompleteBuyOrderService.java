package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.mapper.BuyOrderCompletedMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderCompletedView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.model.BuyOrderStatusEnum;
import com.mercadolibre.projeto_final.domain.model.CartItem;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.service.BuyOrderService;
import com.mercadolibre.projeto_final.domain.service.CompleteBuyOrderService;
import com.mercadolibre.projeto_final.domain.service.FindProductInStockService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
public class ImplCompleteBuyOrderService implements CompleteBuyOrderService {

    private final BuyOrderService buyOrderService;
    private final FindProductInStockService findProductInStockService;
    private final BuyOrderCompletedMapper buyOrderCompletedMapper;

    @Override
    @Transactional
    public BuyOrderCompletedView completeBuyOrder(Long id){

        BuyOrder buyOrder = buyOrderService.findBuyOrderById(id);
        List<CartItem> cartItemsList = buyOrder.getCartItems();

        String msg;
        BuyOrderStatusEnum status;

        try {
            cartItemsList.forEach(item -> {
                Stock validBatch = findProductInStockService.findProductInStock(item.getProductId(), item.getQuantity());
                validBatch.setCurrentQuantity(validBatch.getCurrentQuantity() - item.getQuantity());
            });
            msg = "The BuyOrder was done succesfully! The items will be shipped to your house.";
            status = BuyOrderStatusEnum.CO;
        } catch (ItemNotFoundException e){
            msg = "The items selected previously on your cart are not available anymore.";
            status = BuyOrderStatusEnum.FL;
        }
        buyOrder.setOrderStatus(status);
        return buyOrderCompletedMapper.map(buyOrder,msg);
    }
}
