package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.domain.dtos.form.PutInboundForm;
import com.mercadolibre.projeto_final.domain.dtos.mapper.*;
import com.mercadolibre.projeto_final.domain.dtos.view.StockView;
import com.mercadolibre.projeto_final.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.projeto_final.domain.model.InboundOrder;
import com.mercadolibre.projeto_final.domain.model.Section;
import com.mercadolibre.projeto_final.domain.model.Stock;
import com.mercadolibre.projeto_final.domain.service.FindOrderService;
import com.mercadolibre.projeto_final.domain.service.FindProductService;
import com.mercadolibre.projeto_final.domain.service.RetrieveSectionService;
import com.mercadolibre.projeto_final.domain.service.UpdateStockService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class ImplUpdateStock implements UpdateStockService {

    private final RetrieveSectionService retrieveSectionService;
    private final StockViewMapper stockViewMapper;
    private final FindOrderService findOrderService;
    private final FindProductService findProductService;
    private final StockFormMapper stockFormMapper;



    @Override @Transactional
    public List<StockView> update(PutInboundForm putInboundForm) {

        InboundOrder order = findOrderService.findById(putInboundForm.getOrderNumber());

        List<Stock> stockList = order.getStockList();

        putInboundForm.getBatchStock().forEach( item -> {
            Optional<Stock> stock = stockList.stream().filter( batch ->
                batch.getNumber().equals(item.getNumber())
            ).findFirst();

            if(stock.isEmpty()){
                throw new ItemNotFoundException( "Not Found", "Batch number not found in order.", 404);
            }
            stockFormMapper.updateStockByStockFormAndProduct(stock.get(), item,findProductService.findById(item.getProductId()));

        });

        Section section = retrieveSectionService.findByNameAndWareHouse(
                putInboundForm.getSection().getSectionCode(),
                putInboundForm.getSection().getWarehouseCode());

        //Pedido.setSection talala...
        order.setSection(section);

        return stockViewMapper.mapOrderInStockList(order);


    }
}