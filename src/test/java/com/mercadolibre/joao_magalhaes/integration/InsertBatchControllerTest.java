package com.mercadolibre.joao_magalhaes.integration;

import com.mercadolibre.joao_magalhaes.application.config.security.TokenView;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.*;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertBatchControllerTest extends ControllerTest{


    static LoginForm LOGIN;

    @BeforeAll
    static void beforeAll() {
        LOGIN = new LoginForm();
        LOGIN.setUserName("jorge");
        LOGIN.setPassword("12345");

    }

    @Test
    void shouldReturnCreatedWhenPassValidFormAndValidToken() throws JSONException {
        // given
        InboundOrderForm orderForm = new InboundOrderForm();
        SectionForm sectionForm = new SectionForm();
        StockForm stockForm = new StockForm();

        sectionForm.setSectionCode("a");
        sectionForm.setWarehouseCode("a");

        stockForm.setProductId(2L);
        stockForm.setCurrentTemperature(50F);
        stockForm.setMinimumTemperature(50F);
        stockForm.setInitialQuantity(10);
        stockForm.setCurrentQuantity(10);
        stockForm.setManufacturingDate("03-08-2021");
        stockForm.setManufacturingTime("05-08-2021 16:35");
        stockForm.setDueDate("04-08-2021");

        orderForm.setOrderDate("05-08-2021");
        orderForm.setSection(sectionForm);
        orderForm.setBatchStock(List.of(stockForm));






        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", LOGIN, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();



        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<InboundOrderForm> request = new HttpEntity<>(orderForm, headers);


        ResponseEntity<StockView[]> responseEntity = this.testRestTemplate.postForEntity(
                "/api/v1/fresh-products/inboundorder/",
                request,
                StockView[].class
        );



        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnOkWhenPassValidFormAndValidTokenToUpdateOrder(){

        // Given
        PutStockForm stockForm = new PutStockForm();
        stockForm.setNumber(1L);
        stockForm.setProductId(1L);
        stockForm.setInitialQuantity(50);
        stockForm.setCurrentQuantity(40);
        stockForm.setManufacturingTime("06-08-2021 17:40");
        stockForm.setManufacturingDate("04-08-2021");
        stockForm.setCurrentTemperature(80F);
        stockForm.setMinimumTemperature(90F);
        stockForm.setDueDate("05-08-2021");


        SectionForm sectionForm = new SectionForm();
        sectionForm.setSectionCode("a");
        sectionForm.setWarehouseCode("a");

        PutInboundForm form = new PutInboundForm();
        form.setSection(sectionForm);
        form.setOrderNumber(1L);
        form.setBatchStock(List.of(stockForm));


        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", LOGIN, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();



        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);



        HttpEntity<PutInboundForm> request = new HttpEntity<>(form, headers);

        ResponseEntity<StockView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/inboundorder/",
                HttpMethod.PUT,
                request,
                StockView[].class
        );


        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }



}
