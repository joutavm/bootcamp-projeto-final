package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductWithIdWarehouseView;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StocksByProductInWarehousesMapperTest {
    private final StocksByProductInWarehousesMapper stocksMapper = new StocksByProductInWarehousesMapper();
    @Test
    void shouldReturnProductWithIdWarehouseViewWhenCreateStocksByProductInWarehousesMapper() {
        //Given
        ProductInWarehouseView expected = new ProductInWarehouseView();
        expected.setWarehouseCode("Meli");
        expected.setTotalQuantity(10);

        //When
        ProductWithIdWarehouseView result = stocksMapper.map(List.of(expected, expected), 1L);

        //Then
        assertEquals(1L, result.getProductId());
        assertEquals(expected.getTotalQuantity(), result.getProductInWarehouseViewList().get(0).getTotalQuantity());
        assertEquals(expected.getWarehouseCode(), result.getProductInWarehouseViewList().get(0).getWarehouseCode());

    }
}