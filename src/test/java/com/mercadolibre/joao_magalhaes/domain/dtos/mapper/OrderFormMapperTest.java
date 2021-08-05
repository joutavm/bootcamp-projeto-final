package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.SectionFrom;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class OrderFormMapperTest {

    private final OrderFormMapper orderFormMapper = new OrderFormMapper();

    @Test
    void shouldCreateMapWhenTransformValuesToInboundOrder() {
        //Given
        StockForm form = new StockForm(1L, 1L,
                12.5f, 12.5f,
                12, 12,
                "12-03-2021", "12-03-2021", "12-03-2021");

        InboundOrderForm inboundOrderForm = new InboundOrderForm(new SectionFrom("30", "12"),
                List.of(form, form), "2021-04-12");

        Stock stock = new Stock(1L, new Product(1L, "Cheese"),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,3,12),
                LocalDateTime.of(2021,3,12, 12, 30),
                LocalDate.of(2021,3,12));

        Section section = new Section("12", 200.2,
                new Warehouse("12", List.of(new Section(), new Section())));

        LocalDate dateExpected = LocalDate.of(2021,4,12);

        //When
        InboundOrder result = orderFormMapper.map(inboundOrderForm, List.of(stock, stock), section);

        //Then
        assertEquals(section, result.getSection());
        assertEquals(stock, result.getStockList().get(0));
        assertEquals(dateExpected, result.getOrderDate());
    }
}