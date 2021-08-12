package com.mercadolibre.projeto_final.domain.service.impl;

import com.mercadolibre.projeto_final.application.util.MockitoExtension;
import com.mercadolibre.projeto_final.domain.dtos.mapper.FindWarehouseMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;
import com.mercadolibre.projeto_final.domain.model.*;
import com.mercadolibre.projeto_final.domain.repository.StockRepostitory;
import com.mercadolibre.projeto_final.domain.repository.WarehouseRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ImplFindWarehouseServiceTest {

    @Mock
    private  WarehouseRepository warehouseRepository;
    @Mock
    private  StockRepostitory stockRepostitory;
    @Mock
    private  FindWarehouseMapper findWarehouseMapper;

    ImplFindWarehouseService implFindWarehouseService;

    @BeforeEach
    void setUp() {
        implFindWarehouseService = new ImplFindWarehouseService(warehouseRepository, stockRepostitory, findWarehouseMapper);
    }

    @Test
    public void shouldReturnWarehouseStatisticsViewWhenWarehouseExists() {
        //Given
        Warehouse warehouseExpected = new Warehouse();
        warehouseExpected.setSection(List.of(new Section(), new Section()));
        warehouseExpected.setCode("a");
        warehouseExpected.setId(1L);

        WarehouseStatisticsView viewExpected = new WarehouseStatisticsView();
        viewExpected.setId(1L);
        viewExpected.setCode("a");
        viewExpected.setTotalSize(20.0);
        viewExpected.setTotalProducts(15);
        viewExpected.setQtdSection(3);

        //When
        when(warehouseRepository.findById(any())).thenReturn(Optional.of(warehouseExpected));
        implFindWarehouseService.warehouseStatistics(1L);

        //Then
        verify(warehouseRepository, times(1)).findById(any());
        verify(stockRepostitory, times(1)).findAllByInboundOrder_Section_Warehouse_Id(any());
        verify(findWarehouseMapper, times(1)).map(any(), any());

    }

}