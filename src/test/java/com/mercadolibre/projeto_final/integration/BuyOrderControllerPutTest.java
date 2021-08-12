package com.mercadolibre.projeto_final.integration;

import com.mercadolibre.projeto_final.application.config.security.TokenView;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyOrderForm;
import com.mercadolibre.projeto_final.domain.dtos.form.BuyProductsForm;
import com.mercadolibre.projeto_final.domain.dtos.form.LoginForm;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuyOrderControllerPutTest extends ControllerTest{

    @Test
    void shouldUpdateOrderItemsWhenPassingValidBuyOrderForm(){
        //given
        LoginForm login = new LoginForm();
        login.setUserName("carlos");
        login.setPassword("12345");

        BuyOrderForm buyOrderForm = new BuyOrderForm();
        List<BuyProductsForm> productsList = new ArrayList<>(){{
            add(new BuyProductsForm(1L, 3));
            add(new BuyProductsForm(2L, 2));
        }};
        buyOrderForm.setBuyerId(1L);
        buyOrderForm.setProducts(productsList);

        //when
        ResponseEntity<TokenView> loginEntity = this.testRestTemplate.postForEntity("/auth", login, TokenView.class);
        String token = Objects.requireNonNull(loginEntity.getBody()).getToken();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + token);
        HttpEntity<BuyOrderForm> request = new HttpEntity<>(buyOrderForm, headers);

        ResponseEntity<Object> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/orders/?querytype=1",
                HttpMethod.PUT,
                request,
                Object.class
        );
        //given
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());


    }
}
