package com.mercadolibre.projeto_final.application.controller;

import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;
import com.mercadolibre.projeto_final.domain.dtos.view.OverDueView;
import com.mercadolibre.projeto_final.domain.service.DueDateService;
import com.mercadolibre.projeto_final.domain.service.OverDueService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/fresh-products/due-date")
public class DueDateController {

    private final DueDateService dueDateService;
    private final OverDueService overDueService;

    @GetMapping
    @RequestMapping("/{querytype}")
    public ResponseEntity<List<DueDateView>> listByDueDate(@PathVariable int querytype){
        return ResponseEntity.ok(dueDateService.findByDueDate(querytype));
    }

    @GetMapping
    @RequestMapping("/list")
    public ResponseEntity<List<DueDateView>> listByDueDate(@RequestParam int days, @RequestParam(defaultValue = "") String category, @RequestParam(defaultValue = "") String order){
        return ResponseEntity.ok(dueDateService.findByDueDateSorted(days, category, order));
    }

    @DeleteMapping("/overdue")
    public ResponseEntity<OverDueView> deleteOverDueStocks(){
        return ResponseEntity.ok(overDueService.deleteAll());
    }


}
