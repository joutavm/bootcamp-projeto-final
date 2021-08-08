package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.model.CartItem;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import com.mercadolibre.joao_magalhaes.domain.repository.BuyOrderRepository;
import com.mercadolibre.joao_magalhaes.domain.service.CreateBuyOrderService;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductInStockService;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

public class ImplBuyOrderService implements CreateBuyOrderService {

    BuyOrderRepository buyOrderRepository;
    BuyOrderFormMapper buyOrderFormMapper;
    FindProductInStockService findProductInStockService;

    @Override @Transactional
    public BuyOrderView create(BuyOrderForm buyOrderForm) {
        HashMap<Long, String> returnView = new HashMap<>();
        buyOrderForm.getProducts().forEach(item -> {
            //Trocar nome do service, quem busca or prod é a query.
             try {
                 Stock validStock = findProductInStockService.findProductInStock(item);
                 //TODO: Decrement Stock from validStock
                 //TODO: montar o response - fazer a conta de valor total do carrinho do cara = precoProduto*quantidade.
                 returnView.put(item.getProductId(), "success");
             }catch(Error e){
                 returnView.put(item.getProductId(), "error");
             }
        });
        BuyOrder buyOrder = buyOrderFormMapper.map(buyOrderForm);
        buyOrderRepository.save(buyOrderForm);

        //TODO: Create return body -> BuyOrderView + returnView
    }
}