package com.mercadolibre.projeto_final.domain.service.impl;


import com.mercadolibre.projeto_final.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.mapper.OrderFormMapper;
import com.mercadolibre.projeto_final.domain.dtos.mapper.StockFormMapper;
import com.mercadolibre.projeto_final.domain.dtos.mapper.StockViewMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.StockView;
import com.mercadolibre.projeto_final.domain.model.InboundOrder;
import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.repository.OrderRepository;
import com.mercadolibre.projeto_final.domain.service.CreateOrderService;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import com.mercadolibre.projeto_final.domain.service.RetrieveSectionService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ImplCreateOrder implements CreateOrderService {

    private final OrderRepository orderRepository;
    private final StockViewMapper stockViewMapper;
    private final OrderFormMapper orderFormMapper;
    private final RetrieveSectionService retrieveSectionService;
    private final StockFormMapper stockFormMapper;
    private final FindProductService findProductService;


    @Override @Transactional
    public List<StockView> create(InboundOrderForm form) {
        Section section = retrieveSectionService.findByNameAndWareHouse(
                form.getSection().getSectionCode(),
                form.getSection().getWarehouseCode());


        List<Stock> stockList = form.getBatchStock().stream().map(e ->
            stockFormMapper.updateStockByStockFormAndProduct(e, findProductService.findById(e.getProductId()))
        ).collect(Collectors.toList());


        InboundOrder order = orderFormMapper.map(form, stockList, section);

        InboundOrder response = orderRepository.save(order);

        return stockViewMapper.mapOrderInStockList(response);


    }
}