package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;
import com.mercadolibre.projeto_final.domain.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindWarehouseMapperTest {

    private final FindWarehouseMapper findWarehouseMapper = new FindWarehouseMapper();

    @Test
    void shouldReturnWarehouseStatisticsViewWhenTransformValues() {
        //Given
        Warehouse warehouseExpected = new Warehouse();
        warehouseExpected.setSection(List.of(new Section(), new Section()));
        warehouseExpected.setCode("a");
        warehouseExpected.setId(1L);

        Stock stockExpected = new Stock(1L, new Product(1L, "Cheese", 2.0, CategoryProductEnum.FS),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));

        //When
        WarehouseStatisticsView result = findWarehouseMapper.map(warehouseExpected,List.of(stockExpected, stockExpected));

        //Then
        assertEquals(warehouseExpected.getId(), result.getId());
        assertEquals(warehouseExpected.getCode(), result.getCode());
        assertEquals(warehouseExpected.getSection().size(), result.getQtdSection());
        assertEquals(2, result.getTotalProducts());
    }


}