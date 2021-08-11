package com.mercadolibre.projeto_final.integration;

import com.mercadolibre.projeto_final.application.config.security.TokenView;
import com.mercadolibre.projeto_final.application.controller.DueDateController;
import com.mercadolibre.projeto_final.application.controller.PingController;
import com.mercadolibre.projeto_final.domain.dtos.form.LoginForm;
import com.mercadolibre.projeto_final.domain.dtos.mapper.DueDateMapper;
import com.mercadolibre.projeto_final.domain.dtos.view.DueDateView;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductView;
import com.mercadolibre.projeto_final.domain.exceptions.ApiError;
import com.mercadolibre.projeto_final.domain.exceptions.ApiException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doThrow;

public class DueDateControllerTest extends ControllerTest{

    @SpyBean
    private DueDateController dueDateController;

    @Test
    void shouldReturnOkWhenCalledForListAllProductsByDueDate() {

        //Given

        LoginForm login = new LoginForm();
        login.setUserName("jorge");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> request = new HttpEntity<Object>(headers);

        ResponseEntity<DueDateView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/due-date/5",
                HttpMethod.GET,
                request,
                DueDateView[].class
        );

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnOkWhenCalledForListAllProductsByDueDateAndOrder() {

        //Given

        LoginForm login = new LoginForm();
        login.setUserName("jorge");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> request = new HttpEntity<Object>(headers);

        ResponseEntity<DueDateView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/due-date/list?days=5&category=fs&order=asc",
                HttpMethod.GET,
                request,
                DueDateView[].class
        );

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnBadRequestWhenCalledForWrongPath(){

        //Given

        LoginForm login = new LoginForm();
        login.setUserName("jorge");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> request = new HttpEntity<Object>(headers);


        ResponseEntity<ApiError> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/due-date/list",
                HttpMethod.GET,
                request,
                ApiError.class
        );


        // Then
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }

}
