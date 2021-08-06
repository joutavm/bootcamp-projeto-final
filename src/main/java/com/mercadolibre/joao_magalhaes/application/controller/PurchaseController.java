package com.mercadolibre.joao_magalhaes.application.controller;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductView;
import com.mercadolibre.joao_magalhaes.domain.model.Product;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import com.mercadolibre.joao_magalhaes.domain.service.RetrieveProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/")
public class PurchaseController {

    private final RetrieveProductService retrieveProductService;

    @GetMapping
    public ResponseEntity<List<ProductView>> listAll(){
        return ResponseEntity.ok(retrieveProductService.retrieveProductViewList());
    }
}
