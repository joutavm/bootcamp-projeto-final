package com.mercadolibre.joao_magalhaes.application.controller;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderView;
import com.mercadolibre.joao_magalhaes.domain.service.CreateBuyOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/fresh-products/orders/")
public class CreateBuyOrderController {

    CreateBuyOrderService createBuyOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BuyOrderView createBuyOrder(@RequestBody @Valid BuyOrderForm buyOrderForm){
        return createBuyOrderService.create(buyOrderForm);
    }
}