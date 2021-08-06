package com.mercadolibre.joao_magalhaes.unit;

import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StockViewMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import com.mercadolibre.joao_magalhaes.domain.model.*;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class StockViewMapperTest {


    private final StockViewMapper stockViewMapper = new StockViewMapper();

    @Test
    public void shouldReturnStockView_whenValidStockIsPassed(){
        //given
        Product presunto = new Product(2L,"Presunto", 3.0, CategoryProductEnum.FS);
        Stock source = new Stock(1L,presunto,
                12F,
                13F,
                9,
                10,
                LocalDate.now(),
                LocalDateTime.now(),
                LocalDate.now());
        StockView expected = new StockView(1L,"2",
                12,
                13,
                9,
                10,
                LocalDate.now().toString(),
                LocalDateTime.now().toString(),
                LocalDate.now().toString());
        //when
        StockView view = stockViewMapper.map(source);

        //then
        assertEquals(view.getCurrentQuantity(), expected.getCurrentQuantity());
        assertEquals(view.getCurrentTemperature(), expected.getCurrentTemperature());
        assertEquals(view.getDueDate(), expected.getDueDate());
        assertEquals(view.getInitialQuantity(), expected.getInitialQuantity());
        assertEquals(view.getManufacturingDate(), expected.getManufacturingDate());
        assertEquals(view.getNumber(), expected.getNumber());
        assertEquals(view.getProductId(), expected.getProductId());

    }

    @Test
    public void shouldReturnStockViewList_whenPassingValidInboundOrder(){
        //given
        Product presunto = new Product(2L,"Presunto", 3.0, CategoryProductEnum.FS);
        Stock source = new Stock(1L,presunto,
                12F,
                13F,
                9,
                10,
                LocalDate.now(),
                LocalDateTime.now(),
                LocalDate.now());
        List<Stock> stockList = new ArrayList<>();
        stockList.add(source);
        Warehouse warehouse = new Warehouse("1234", new ArrayList<>());
        Section section = new Section("151515",2.0,warehouse);
        List<Section> sectionList = new ArrayList<>();
        sectionList.add(section);
        warehouse.setSection(sectionList);
        InboundOrder order = new InboundOrder(1234L,LocalDate.of(2020, 7, 7),section,stockList);

        //when
        List<StockView> result = stockViewMapper.mapOrderInStockList(order);


        //then
        assertEquals(presunto.getId().toString(),result.get(0).getProductId());
    }



}