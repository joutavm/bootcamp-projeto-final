package com.mercadolibre.joao_magalhaes.integration;

import com.mercadolibre.joao_magalhaes.application.config.security.TokenView;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.form.LoginForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.BuyOrderProductsView;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOrderControllerGetTest extends ControllerTest{

    @Test
    void shouldReturnOrderItemsWhenPassingValidOrderId(){
        //Given
        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        //When
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<?> request = new HttpEntity<Objects>(headers);

        ResponseEntity<BuyOrderProductsView[]> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/",
                HttpMethod.GET,
                request,
                BuyOrderProductsView[].class);


        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
