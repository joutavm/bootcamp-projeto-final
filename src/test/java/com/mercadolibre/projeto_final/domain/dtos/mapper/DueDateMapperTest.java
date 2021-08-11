package com.mercadolibre.projeto_final.domain.dtos.mapper;

import com.mercadolibre.projeto_final.domain.dtos.form.StockForm;
import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;
import com.mercadolibre.projeto_final.domain.model.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DueDateMapperTest {

    private final DueDateMapper dueDateMapper = new DueDateMapper();

    @Test
    void shouldReturnDueDateViewWhenTransformValues() {

        StockForm form = new StockForm(1L, 1L,
                12.5f, 12.5f,
                12, 12,
                "12-03-2021", "12-03-2021", "12-03-2021");

        Section section = new Section("12", 200.2,
                new Warehouse("12", List.of(new Section(), new Section())));

        Product product = new Product(1L, "Cheese", 12.2, CategoryProductEnum.FS);

        //Given
        Stock stock = new Stock();
        stock.setDueDate(LocalDate.of(2021,4,12));
        stock.setCurrentQuantity(12);
        stock.setCurrentTemperature(12.2f);
        stock.setManufacturingDate(LocalDate.of(2021,4,12));
        stock.setInboundOrder(new InboundOrder(LocalDate.of(2021,4,12), section, List.of(stock, stock)));
        stock.setMinimumTemperature(12.2f);
        stock.setNumber(1L);
        stock.setProduct(product);
        stock.setManufacturingTime(LocalDateTime.of(2021,4,12, 12, 12));
        stock.setInitialQuantity(12);

        //When
        DueDateView result = dueDateMapper.map(stock);

        //Then
        assertEquals(stock.getDueDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), result.getDueDate());
        assertEquals(stock.getCurrentQuantity(), result.getQuantity());
        assertEquals(stock.getInboundOrder().getSection().getCode(), result.getSection());
        assertEquals(stock.getProduct().getId().toString(), result.getProductId());
        assertEquals(stock.getProduct().getCategory().toString(), result.getCategory());
        assertEquals(stock.getNumber().intValue(), result.getBatchNumber());
        assertEquals(stock.getInboundOrder().getSection().getWarehouse().getCode(), result.getWarehouse());
    }
}