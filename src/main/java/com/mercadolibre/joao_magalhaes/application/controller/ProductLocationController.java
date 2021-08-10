package com.mercadolibre.joao_magalhaes.application.controller;


import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductLocationView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.joao_magalhaes.domain.repository.OrderRepository;
import com.mercadolibre.joao_magalhaes.domain.repository.StockRepostitory;
import com.mercadolibre.joao_magalhaes.domain.service.ProductLocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.time.LocalDate;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/list")
public class ProductLocationController {

    private final ProductLocationService productLocationService;

    @GetMapping
    public ResponseEntity<List<ProductLocationView>> listById(@RequestParam("querytype") Long id, @RequestParam(value = "querytype", required = false) Character order){

        return ResponseEntity.ok(productLocationService.findByStockSorted(id, order));
    }

}
