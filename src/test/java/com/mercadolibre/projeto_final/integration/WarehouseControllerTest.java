package com.mercadolibre.projeto_final.integration;

import com.mercadolibre.projeto_final.application.config.security.TokenView;
import com.mercadolibre.projeto_final.domain.dtos.form.LoginForm;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductLocationView;
import com.mercadolibre.projeto_final.domain.dtos.view.WarehouseStatisticsView;
import com.mercadolibre.projeto_final.domain.exceptions.ApiError;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseControllerTest extends ControllerTest{

    @Test
    void shouldReturn200WhenFindWarehouse() throws JSONException {
        // given
        WarehouseStatisticsView view = new WarehouseStatisticsView();
        view.setId(1L);
        view.setCode("a");
        view.setTotalSize(20.0);
        view.setTotalProducts(15);
        view.setQtdSection(15);

        LoginForm login = new LoginForm();
        login.setUserName("jorge");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<WarehouseStatisticsView> request = new HttpEntity<>(view, headers);


        ResponseEntity<ProductLocationView> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/warehouseStatistics/1",
                HttpMethod.GET,
                request,
                ProductLocationView.class
        );

        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnNotFoundWhenFindWarehouse(){
        //Given
        LoginForm login = new LoginForm();
        login.setUserName("jorge");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<String> request = new HttpEntity<>(headers);

        ResponseEntity<ApiError> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/warehouseStatistics/2",
                HttpMethod.GET,
                request,
                ApiError.class
        );

        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }

}