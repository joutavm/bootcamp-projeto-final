package com.mercadolibre.joao_magalhaes.application.controller;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.service.CreateBuyOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/fresh-products/orders/")
@RequiredArgsConstructor
public class BuyOrderController {

    private final CreateBuyOrderService createBuyOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BuyOrderView createBuyOrder(@RequestBody @Valid BuyOrderForm buyOrderForm){
        return createBuyOrderService.create(buyOrderForm);
    }

    @GetMapping()
    public BuyOrderProductsView getOrderItems(@PathVariable(name= "querytype") String param){ return getBuyOrderProductsService.getProducts();}
}