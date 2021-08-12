package com.mercadolibre.projeto_final.application.controller;

import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderCompletedView;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderView;
import com.mercadolibre.projeto_final.domain.service.CompleteBuyOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/complete")
@RequiredArgsConstructor
public class CompleteBuyOrderController {

    private final CompleteBuyOrderService completeBuyOrderService;

    @GetMapping("/{id}")
    public BuyOrderCompletedView completeBuyOrder(@PathVariable Long id){
        return completeBuyOrderService.completeBuyOrder(id);
    }
}
