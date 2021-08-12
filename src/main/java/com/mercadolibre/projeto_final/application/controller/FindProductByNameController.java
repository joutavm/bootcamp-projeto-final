package com.mercadolibre.projeto_final.application.controller;


import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.service.FindProductByNameService;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/name")
public class FindProductByNameController {

    private final FindProductByNameService findProductByNameService;

    @GetMapping("/{name}")
    public ResponseEntity<ProductView> listAllByName(@PathVariable("name") String name) {
        return ResponseEntity.ok(findProductByNameService.findProductByName(name));
    }
}
