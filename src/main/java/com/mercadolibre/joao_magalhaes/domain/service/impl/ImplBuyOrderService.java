package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.BuyOrderFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.model.BuyOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import com.mercadolibre.joao_magalhaes.domain.repository.BuyOrderRepository;
import com.mercadolibre.joao_magalhaes.domain.service.CreateBuyOrderService;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductInStockService;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class ImplBuyOrderService implements CreateBuyOrderService {

    private final FindProductInStockService findProductInStockService;
    private final FindProductService findProductService;

    @Override @Transactional
    public BuyOrderView create(BuyOrderForm buyOrderForm) {

        AtomicReference<Double> total = new AtomicReference<>(0.0);
        HashMap<Long, String> returnView = new HashMap<>();
        buyOrderForm.getProducts().forEach(item -> {
            //Trocar nome do service, quem busca or prod é a query.
             try {
                 Stock validStock = findProductInStockService.findProductInStock(item);
                 //TODO: Decrement Stock from validStock

                 Double price = findProductService.findById(item.getProductId()).getPrice();
                 total.updateAndGet(v -> v + item.getQuantity() * price);

                 returnView.put(item.getProductId(), "success");
             }catch(Error e){
                 returnView.put(item.getProductId(), "error");
             }
        });

        return new BuyOrderView(total, returnView);

//        BuyOrder buyOrder = buyOrderFormMapper.map(buyOrderForm);
//        buyOrderRepository.save(buyOrderForm);

    }
}