package com.mercadolibre.projeto_final.domain.service;

import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.BuyOrder;
import com.mercadolibre.projeto_final.domain.repository.BuyOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BuyOrderService {

    private final BuyOrderRepository buyOrderRepository;

    public BuyOrder findBuyOrderById(Long id){
        Optional<BuyOrder> buyOrder = buyOrderRepository.findById(id);
        if(buyOrder.isEmpty()){
            throw new ItemNotFoundException("BuyOrder Not Found", "BuyOrder not found.",404);
        }
        return buyOrder.get();
    }
}
