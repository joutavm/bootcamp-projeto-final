package com.mercadolibre.joao_magalhaes.domain.dtos.mapper;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.PutInboundForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.PutStockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.SectionForm;
import com.mercadolibre.joao_magalhaes.domain.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class PutOrderFormMapperTest {

    private final PutOrderFormMapper putOrderFormMapper = new PutOrderFormMapper();

    @Test
    void shouldCreateMapWhenTransformValuesToInboundOrder(){
        //Given
        SectionForm section = new SectionForm("a", "a");
        List<PutStockForm> batchStock = new ArrayList<>();
        batchStock.add(new PutStockForm(1L, 1L, 12.5f,
                12.5f, 12, 12,
                LocalDate.of(2021, 10, 10).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDateTime.of(2021, 10,10,10,10).format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                LocalDate.of(2021,10,10).format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));

        List<Stock> inputBatchStock = new ArrayList<>();
        Stock stock = new Stock(1L, new Product(1L, "Cheese"),
                12.5f, 12.5f, 12, 12,
                LocalDate.of(2021,10,10),
                LocalDateTime.of(2021,10,10, 10, 10),
                LocalDate.of(2021,10,10));
        inputBatchStock.add(stock);

        Section inputSection = new Section("a", 200.2,
                new Warehouse("a", List.of(new Section(), new Section())));

        PutInboundForm inputForm = new PutInboundForm(1L, section, batchStock);

        InboundOrder expected = new InboundOrder(LocalDate.of(2021, 10, 10), inputSection, inputBatchStock);

        //When
        InboundOrder putOrderFormMapperResult = putOrderFormMapper.map(inputForm, inputBatchStock, inputSection);

        //Then

        Assertions.assertEquals(expected.getOrderNumber(), putOrderFormMapperResult.getOrderNumber());
    }
}