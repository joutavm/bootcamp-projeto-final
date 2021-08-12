package com.mercadolibre.projeto_final.application.controller;

import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import com.mercadolibre.projeto_final.domain.service.RetrieveProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/")
public class PurchaseController {

    private final RetrieveProductService retrieveProductService;
    private final FindProductService findProductService;

    @GetMapping
    public ResponseEntity<List<ProductView>> listAll(){
        return ResponseEntity.ok(retrieveProductService.retrieveProductViewList());
    }

    @GetMapping("/{category}")
    public ResponseEntity<List<ProductView>> listAllByCategory(@PathVariable("category") String category) {
        return ResponseEntity.ok(findProductService.findAllProductsByCategory(category));
    }

    @GetMapping("/price/{order}")
    public ResponseEntity<List<ProductView>> listAllAndSortByPrice(@PathVariable("order") String order){
        return ResponseEntity.ok(retrieveProductService.findAllSortedByPrice(order));
    }
}