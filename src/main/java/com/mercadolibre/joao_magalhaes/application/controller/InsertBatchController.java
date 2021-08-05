package com.mercadolibre.joao_magalhaes.application.controller;


import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import com.mercadolibre.joao_magalhaes.domain.service.CreateOrderService;
import com.mercadolibre.joao_magalhaes.domain.service.UpdateStockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder/")
public class InsertBatchController {

//    private final CreateOrderService createOrderService;
//
//    private final UpdateStockService updateStockService;
//
//
//    @PostMapping
//    @ResponseStatus(value = HttpStatus.CREATED)
//    public List<StockView> insert(@RequestBody @Valid InboundOrderForm form){
//        return createOrderService.create(form);
//    }
//
//
//    @PutMapping("/{id}")
//    public ResponseEntity<StockView> update(@PathVariable String id, @RequestBody @Valid StockForm stockForm){
//        return ResponseEntity.ok().body(updateStockService.update(id, stockForm));
//    }
}