package com.mercadolibre.projeto_final.application.controller;


import com.mercadolibre.projeto_final.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.form.PutInboundForm;
import com.mercadolibre.projeto_final.domain.dtos.view.StockView;
import com.mercadolibre.projeto_final.domain.service.CreateOrderService;
import com.mercadolibre.projeto_final.domain.service.UpdateStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder/")
public class InsertBatchController {

    private final CreateOrderService createOrderService;

    private final UpdateStockService updateStockService;


    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<StockView> insert(@RequestBody @Valid InboundOrderForm form){
        return createOrderService.create(form);
    }


    @PutMapping
    @ResponseStatus(value = HttpStatus.OK)
    public List<StockView> update(@RequestBody @Valid PutInboundForm putInboundForm){
        return updateStockService.update(putInboundForm);
    }
}