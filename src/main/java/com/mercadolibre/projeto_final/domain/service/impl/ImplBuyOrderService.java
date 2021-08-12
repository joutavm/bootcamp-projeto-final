package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.mapper.BuyOrderFormMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.repository.BuyOrderRepository;
import com.mercadolibre.projeto_final.domain.service.CreateBuyOrderService;
import com.mercadolibre.projeto_final.domain.service.FindProductInStockService;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

@RequiredArgsConstructor
public class ImplBuyOrderService implements CreateBuyOrderService{

    private final FindProductInStockService findProductInStockService;
    private final FindProductService findProductService;
    private final BuyOrderFormMapper buyOrderFormMapper;
    private final BuyOrderRepository buyOrderRepository;

    @Override @Transactional
    public BuyOrderView create(BuyOrderForm buyOrderForm) {

        AtomicReference<Double> total = new AtomicReference<>(0.0);
        HashMap<Long, String> returnView = new HashMap<>();
        buyOrderForm.getProducts().forEach(item -> {
             try {
                 Stock validBatch = findProductInStockService.findProductInStock(item);
                 //TODO: Decrementar do lote validBatch a quantidade do produto

                 Double price = findProductService.findById(item.getProductId()).getPrice();
                 total.updateAndGet(v -> v + item.getQuantity() * price);

                 returnView.put(item.getProductId(), "success");
             }catch(ItemNotFoundException e){
                 returnView.put(item.getProductId(), "error");
             }
        });
        BuyOrder buyOrder = buyOrderFormMapper.map(buyOrderForm, returnView);
        buyOrderRepository.save(buyOrder);

        return new BuyOrderView(total, returnView);
    }
}