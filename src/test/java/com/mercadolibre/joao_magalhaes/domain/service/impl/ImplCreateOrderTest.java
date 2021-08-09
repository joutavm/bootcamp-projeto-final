package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.application.util.MockitoExtension;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.SectionForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.OrderFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StockFormMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StockViewMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import com.mercadolibre.joao_magalhaes.domain.model.*;
import com.mercadolibre.joao_magalhaes.domain.repository.OrderRepository;
import com.mercadolibre.joao_magalhaes.domain.service.FindProductService;
import com.mercadolibre.joao_magalhaes.domain.service.RetrieveSectionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ImplCreateOrderTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private StockViewMapper stockViewMapper;
    @Mock
    private OrderFormMapper orderFormMapper;
    @Mock
    private RetrieveSectionService retrieveSectionService;
    @Mock
    private StockFormMapper stockFormMapper;
    @Mock
    private FindProductService findProductService;

    @InjectMocks
    private ImplCreateOrder implCreateOrder;

    @BeforeEach
    void setUp(){
        implCreateOrder = new ImplCreateOrder(
                orderRepository,
                stockViewMapper,
                orderFormMapper,
                retrieveSectionService,
                stockFormMapper,
                findProductService
        );
    }

    @Test
    void shouldCreateStockWhenGivenAnInboundOrderForm(){

        //Given
        List<Section> sectionList= new ArrayList<>(){
            {
                add(new Section("a", 10 , new Warehouse()));
            }
        };
        Section section = new Section(
                "a",
                10,
                new Warehouse("a", sectionList));

        StockForm stockForm = new StockForm(
                1L,
                1L,
                10.2f,
                10f,
                10,
                10,
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        Product product = new Product(
                "presunto",
                10.2,
                CategoryProductEnum.FF);
        Stock stock = new Stock(
                1L,
                product,
                10.2f,
                10f,
                10,
                10,
                LocalDate.now(),
                LocalDateTime.now(),
                LocalDate.now()
                );
        SectionForm sectionForm = new SectionForm(
                "a",
                "a");
        List<StockForm> listStockForm = new ArrayList<>(){
            { add(stockForm); }
        };
        InboundOrderForm inboundForm = new InboundOrderForm(
                sectionForm,
                listStockForm,
                "2021-10-10"
                );
        List<Stock> stockList = new ArrayList<>(){
            { add(stock); }
        };
        InboundOrder inboundOrder = new InboundOrder(
                LocalDate.now(),
                section,
                stockList
        );
        StockView stockView = new StockView(
                1L,
                "1",
                10.2f,
                10f,
                10,
                10,
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        List<StockView> stockViewList = new ArrayList<>(){
            { add(stockView); }
        };
        InboundOrderForm form = new InboundOrderForm(
                sectionForm,
                listStockForm,
                "2010-10-10");


        //When
        when(retrieveSectionService.findByNameAndWareHouse("a", "a"))
                .thenReturn(section);
        when(stockFormMapper.map(stockForm, product))
                .thenReturn(stock);
        when(orderFormMapper.map(inboundForm, stockList, section))
                .thenReturn(inboundOrder);
        when(orderRepository.save(inboundOrder))
                .thenReturn(inboundOrder);
        when(stockViewMapper.mapOrderInStockList(inboundOrder))
                .thenReturn(stockViewList);
        when(implCreateOrder.create(form)).thenReturn(stockViewList);
        List<StockView> result = implCreateOrder.create(form);

        //Then
        Assertions.assertEquals(result.get(0).getCurrentQuantity()
                ,stockViewList.get(0).getCurrentQuantity() );

    }


}