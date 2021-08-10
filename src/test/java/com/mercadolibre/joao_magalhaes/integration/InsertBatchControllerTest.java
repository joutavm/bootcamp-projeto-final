package com.mercadolibre.joao_magalhaes.integration;

import com.mercadolibre.joao_magalhaes.application.config.security.TokenView;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.LoginForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.SectionForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.StockForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertBatchControllerTest extends ControllerTest{



    @Test
    void shouldReturnCreatedWhenPassValidForm() throws JSONException {
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



        LoginForm login = new LoginForm();
        login.setUserName("jorge");
        login.setPassword("12345");


        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
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

}
