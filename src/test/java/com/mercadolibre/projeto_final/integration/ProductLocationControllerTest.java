package com.mercadolibre.projeto_final.integration;

import com.mercadolibre.projeto_final.application.config.security.TokenView;
import com.mercadolibre.projeto_final.domain.dtos.form.LoginForm;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductInWarehouseView;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductLocationView;
import com.mercadolibre.projeto_final.domain.dtos.view.ProductWithIdWarehouseView;
import com.mercadolibre.projeto_final.domain.exceptions.ApiError;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class ProductLocationControllerTest extends ControllerTest {

    @Test
    void shouldReturn200WhenFindListById() throws JSONException {
        // given
        ProductLocationView locationView = new ProductLocationView();
        locationView.setProductId(1L);
        locationView.setDueDate("22-09-2021");
        locationView.setCurrentQuantity(12);
        locationView.setSectionCode("12");
        locationView.setBatchNumber(1L);

        List<ProductLocationView> locationViews = Arrays.asList(locationView, locationView);

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<List<ProductLocationView>> request = new HttpEntity<>(locationViews, headers);


        ResponseEntity<ProductLocationView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/list/?querytype=1",
                HttpMethod.GET,
                request,
                ProductLocationView[].class
        );

        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturn200WhenFindListByIdByOrderCategory() throws JSONException {
        // given
        ProductLocationView locationView = new ProductLocationView();
        locationView.setProductId(1L);
        locationView.setDueDate("22-09-2021");
        locationView.setCurrentQuantity(12);
        locationView.setSectionCode("12");
        locationView.setBatchNumber(1L);

        List<ProductLocationView> locationViews = Arrays.asList(locationView, locationView);

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<?> request = new HttpEntity<>(locationViews, headers);


        ResponseEntity<ProductLocationView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/list/?querytype=1&querytype=C",
                HttpMethod.GET,
                request,
                ProductLocationView[].class
        );

        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturn200WhenFindListByIdByOrderDate() throws JSONException {
        // given
        ProductLocationView locationView = new ProductLocationView();
        locationView.setProductId(1L);
        locationView.setDueDate("22-09-2021");
        locationView.setCurrentQuantity(12);
        locationView.setSectionCode("12");
        locationView.setBatchNumber(1L);

        List<ProductLocationView> locationViews = Arrays.asList(locationView, locationView);

        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<List<ProductLocationView>> request = new HttpEntity<>(locationViews, headers);


        ResponseEntity<ProductLocationView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/list/?querytype=1&querytype=F",
                HttpMethod.GET,
                request,
                ProductLocationView[].class
        );

        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Test
    void shouldReturnNotFoundWhenListById(){
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
                "/api/v1/fresh-products/list/?querytype=6&querytype=XXXX",
                HttpMethod.GET,
                request,
                ApiError.class
        );

        // Then
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }


    @Test
    void shouldReturn200WhenListByWarehouse() throws JSONException {
        // given
        ProductWithIdWarehouseView locationView = new ProductWithIdWarehouseView();
        locationView.setProductId(1L);
        locationView.setProductInWarehouseViewList(List.of(new ProductInWarehouseView()));

//        List<ProductLocationView> locationViews = Arrays.asList(locationView, locationView);

        LoginForm login = new LoginForm();
        login.setUserName("jorge");
        login.setPassword("12345");

        // When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();


        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<ProductWithIdWarehouseView> request = new HttpEntity<>(locationView, headers);


        ResponseEntity<ProductWithIdWarehouseView> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/warehouse/1",
                HttpMethod.GET,
                request,
                ProductWithIdWarehouseView.class
        );

        //Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}