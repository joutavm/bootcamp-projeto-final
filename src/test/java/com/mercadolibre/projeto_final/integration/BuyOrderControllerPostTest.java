package com.mercadolibre.projeto_final.integration;

import com.mercadolibre.projeto_final.application.config.security.TokenView;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.projeto_final.domain.dtos.form.LoginForm;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderView;
import jdk.jfr.Description;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOrderControllerPostTest extends ControllerTest{

    @Test
    @Description("Should return created, and both products should have available stock, returning success")
    void shouldReturnSuccess() throws JSONException {
        //Given
        BuyOrderForm buyOrderForm = new BuyOrderForm();
        //Look into data-integration_test.sql for available stock for each product.
        List<BuyProductsForm> productsList = new ArrayList<>(){{
            add(new BuyProductsForm(1L, 3));
            add(new BuyProductsForm(2L, 2));
        }};
        buyOrderForm.setBuyerId(1L);
        buyOrderForm.setProducts(productsList);

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        //When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<BuyOrderForm> request = new HttpEntity<>(buyOrderForm, headers);

        ResponseEntity<BuyOrderView> responseEntity = this.testRestTemplate.postForEntity(
                "/api/v1/fresh-products/orders/",
                request,
                BuyOrderView.class
        );
        //Then

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("success", responseEntity.getBody().getReturnView().get(1L));
        assertEquals("success", responseEntity.getBody().getReturnView().get(2L));
        assertEquals(new AtomicReference<>(35.0).get(), responseEntity.getBody().getTotalPrice().get());

    }

    @Test
    @Description("Should Return error when passed more stock than available")
    void shourReturnError() throws JSONException {
        //Given
        BuyOrderForm buyOrderForm = new BuyOrderForm();
        //Look into data-integration_test.sql for available stock for each product.
        List<BuyProductsForm> productsList = new ArrayList<>(){{
            add(new BuyProductsForm(1L, 5000));
            add(new BuyProductsForm(2L, 5000));
        }};
        buyOrderForm.setBuyerId(1L);
        buyOrderForm.setProducts(productsList);

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        //When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<BuyOrderForm> request = new HttpEntity<>(buyOrderForm, headers);

        ResponseEntity<BuyOrderView> responseEntity = this.testRestTemplate.postForEntity(
                "/api/v1/fresh-products/orders/",
                request,
                BuyOrderView.class
        );
        //Then

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals("error", responseEntity.getBody().getReturnView().get(1L));
        assertEquals("error", responseEntity.getBody().getReturnView().get(2L));
        assertEquals(new AtomicReference<>(0.0).get(), responseEntity.getBody().getTotalPrice().get());
    }


}