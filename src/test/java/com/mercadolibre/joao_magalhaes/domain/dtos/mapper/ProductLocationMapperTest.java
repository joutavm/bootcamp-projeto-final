package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.view.ProductLocationView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view_sql.ProductLocationSqlView;
import com.mercadolibre.joao_magalhaes.domain.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class ProductLocationMapperTest {

    ProductLocationMapper productLocationMapper;

    @BeforeEach
    void setUp(){
        productLocationMapper = new ProductLocationMapper();
    }

    @Test
    public void shouldReturnProductLocationViewWhenProductLocationSqlViewIsPassed() {
        // given

        Stock stock = new Stock(1L, new Product(1L, "Cheese", 2.0, CategoryProductEnum.FS),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021, 3, 12),
                LocalDateTime.of(2021, 3, 12, 12, 30),
                LocalDate.of(2021, 3, 12));

        Section section = new Section("12", 200.2,
                new Warehouse("12", List.of(new Section(), new Section())));

        InboundOrder inboundOrder = new InboundOrder(LocalDate.of(2022, 3, 12), section, List.of(stock, stock));

        stock.setInboundOrder(inboundOrder);

        ProductLocationSqlView productLocationSqlView = new ProductLocationSqlView();
        productLocationSqlView.setStock(stock);
        productLocationSqlView.setSection(section);

        ProductLocationView expect = new ProductLocationView("12", "12", 1L, 1L, 12, "12-03-2021");
        // when
        ProductLocationView result = productLocationMapper.map(productLocationSqlView);

        //then
        assertEquals(expect.getSectionCode(), result.getSectionCode());
        assertEquals(expect.getWarehouseCode(), result.getWarehouseCode());
        assertEquals(expect.getDueDate(), result.getDueDate());
        assertEquals(expect.getProductId(), result.getProductId());
        assertEquals(expect.getBatchNumber(), result.getBatchNumber());
        assertEquals(expect.getCurrentQuantity(), result.getCurrentQuantity());
    }
}