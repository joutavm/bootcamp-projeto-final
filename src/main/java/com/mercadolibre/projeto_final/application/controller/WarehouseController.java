package com.mercadolibre.projeto_final.application.controller;


import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;
import com.mercadolibre.projeto_final.domain.service.FindWarehouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/warehouseStatistics")
public class WarehouseController {
    private final FindWarehouseService findWarehouseService;

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseStatisticsView> findWarehouse(@PathVariable("id") Long id) {
        return ResponseEntity.ok(findWarehouseService.warehouseStatistics(id));
    }

}
