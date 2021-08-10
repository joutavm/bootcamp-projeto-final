package com.mercadolibre.joao_magalhaes.domain.service.impl;

import com.mercadolibre.joao_magalhaes.application.util.MockitoExtension;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.SectionForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductInWarehouseMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.ProductLocationMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.mapper.StocksByProductInWarehousesMapper;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductLocationView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.joao_magalhaes.domain.exceptions.ItemNotFoundException;
import com.mercadolibre.joao_magalhaes.domain.model.*;
import com.mercadolibre.joao_magalhaes.domain.repository.StockRepostitory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ImplProductLocationTest {

    @Mock
    StockRepostitory stockRepostitory;

    @Mock
    ProductLocationMapper productLocationMapper;

    @Mock
    ProductInWarehouseMapper productInWarehouseMapper;

    @Mock
    StocksByProductInWarehousesMapper stocksByProductInWarehousesMapper;

    ImplProductLocation implProductLocation;



    @BeforeEach
    void setUp() {
        implProductLocation = new ImplProductLocation(stockRepostitory, productLocationMapper, productInWarehouseMapper, stocksByProductInWarehousesMapper);
    }

    @Test
    public void shouldReturnProductLocationListWhenProductIsInStock(){
        // given

        Stock stock = new Stock(1L, new Product(1L, "Cheese", 2.0, CategoryProductEnum.FS),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));

        Section section = new Section("12", 200.2,
                new Warehouse("12", List.of(new Section(), new Section())));

        InboundOrder inboundOrder = new InboundOrder(LocalDate.of(2021,3,12), section, List.of(stock, stock));

        stock.setInboundOrder(inboundOrder);

        ProductLocationSqlView productLocationSqlView = new ProductLocationSqlView();
        productLocationSqlView.setStock(stock);
        productLocationSqlView.setSection(section);

        List<ProductLocationSqlView> productLocationSqlViewList = new ArrayList<>();
        productLocationSqlViewList.add(productLocationSqlView);

        ProductLocationView productLocationView = new ProductLocationView("12", "12", 1L, 1L, 12, "12-03-2021");

        List<ProductLocationView> expect = new ArrayList<>();
        expect.add(productLocationView);
        // when

        when(stockRepostitory.findByStockList(any())).thenReturn(productLocationSqlViewList);
        when(productLocationMapper.map(any())).thenReturn(productLocationView);

        List<ProductLocationView> result = implProductLocation.findByStockList(1L);
        // then

        assertEquals(expect, result);
    }

    @Test
    void shouldThrowExceptionWhenProductNotExists(){
        // given
        List<ProductLocationSqlView> productLocationSqlViewList = new ArrayList<>();

        // when
        when(stockRepostitory.findByStockList(any())).thenReturn(productLocationSqlViewList);

        // Then
        assertThrows(ItemNotFoundException.class, () -> implProductLocation.findByStockList(1L));
    }
}