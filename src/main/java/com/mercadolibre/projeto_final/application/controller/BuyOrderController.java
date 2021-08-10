package com.mercadolibre.projeto_final.application.controller;

import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderView;
import com.mercadolibre.projeto_final.domain.service.CreateBuyOrderService;
import com.mercadolibre.projeto_final.domain.service.GetBuyOrderProductsService;
import com.mercadolibre.projeto_final.domain.service.UpdateOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/orders/")
@RequiredArgsConstructor
public class BuyOrderController {

    private final CreateBuyOrderService createBuyOrderService;
    private final GetBuyOrderProductsService getBuyOrderProductsService;
    private final UpdateOrderService updateOrderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BuyOrderView createBuyOrder(@RequestBody @Valid BuyOrderForm buyOrderForm){
        return createBuyOrderService.create(buyOrderForm);
    }

    @GetMapping()
    public List<BuyOrderProductsView> getOrderItems(@RequestParam(name= "querytype") Long param){
        return getBuyOrderProductsService.getProducts(param);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void updateOrderItems(@RequestParam(name= "querytype") Long param, @RequestBody @Valid BuyOrderForm buyOrderForm){
         updateOrderService.updateOrder(param,buyOrderForm);}
}