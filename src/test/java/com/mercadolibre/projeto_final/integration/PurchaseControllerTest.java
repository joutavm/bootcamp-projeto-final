package com.mercadolibre.projeto_final.integration;

import com.mercadolibre.projeto_final.application.config.security.TokenView;
import com.mercadolibre.projeto_final.domain.dtos.form.LoginForm;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.exceptions.ApiError;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseControllerTest extends ControllerTest{

    @Test
    void shouldReturnOkWhenCalledForListAllProducts(){

        //Given

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> request = new HttpEntity<Object>(headers);


        ResponseEntity<ProductView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/",
                HttpMethod.GET,
                request,
                ProductView[].class
        );

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnOkWhenCalledForListAllProductsForCategory(){

        //Given

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> request = new HttpEntity<>(headers);


        ResponseEntity<ProductView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/FS",
                HttpMethod.GET,
                request,
                ProductView[].class
        );

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnNotFoundWhenCalledForListAllProductsForCategory(){

        //Given

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> request = new HttpEntity<>(headers);


        ResponseEntity<ApiError> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/AA",
                HttpMethod.GET,
                request,
                ApiError.class
        );


        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }
}