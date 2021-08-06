package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.PutInboundForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.OrderFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.PutOrderFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.PutstockFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StockViewMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.InboundOrder;
import com.mercadolibre.joao_magalhaes.domain.model.Section;
import com.mercadolibre.joao_magalhaes.domain.model.Stock;
import com.mercadolibre.joao_magalhaes.domain.repository.OrderRepository;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import com.mercadolibre.joao_magalhaes.domain.service.RetrieveSectionService;
import com.mercadolibre.joao_magalhaes.domain.service.UpdateStockService;
import lombok.RequiredArgsConstructor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class ImplUpdateStock implements UpdateStockService {

    private final RetrieveSectionService retrieveSectionService;
    private final PutOrderFormMapper putOrderFormMapper;
    private final OrderRepository orderRepository;
    private final StockViewMapper stockViewMapper;



    @Override @Transactional
    public List<StockView> update(PutInboundForm putInboundForm) {
        //Achar o pedido
        // TODO: Incapsular em um service. (FindProductService)
        InboundOrder order = orderRepository.findById(putInboundForm.getOrderNumber()).get();

        List<Stock> stockList = order.getStockList();

        putInboundForm.getBatchStock().forEach( item -> {
            Optional<Stock> stock = stockList.stream().filter( batch ->
                batch.getNumber().equals(item.getNumber())
            ).findFirst();

            if(stock.isEmpty()){
                throw new ItemNotFoundException( "Not Found", "Batch number not found in order.", 404);
            }
            stock.get().setDueDate(); //... trabalho do mapper.

        });

        Section section = retrieveSectionService.findByNameAndWareHouse(
                putInboundForm.getSection().getSectionCode(),
                putInboundForm.getSection().getWarehouseCode());

        //Pedido.setSection talala...
        putOrderFormMapper.map(order, putInboundForm, section);

       // InboundOrder response = orderRepository.save(order);

        return stockViewMapper.mapOrderInStockList(order);


    }
}