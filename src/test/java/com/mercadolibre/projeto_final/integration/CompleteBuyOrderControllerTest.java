package com.mercadolibre.projeto_final.integration;

import com.mercadolibre.projeto_final.application.config.security.TokenView;
import com.mercadolibre.projeto_final.domain.dtos.form.LoginForm;
import com.mercadolibre.projeto_final.domain.dtos.view.BuyOrderCompletedView;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CompleteBuyOrderControllerTest extends ControllerTest{

    @Test
    void shouldReturnBuyOrderCompletedView_WhenPassingID(){
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

        ResponseEntity<BuyOrderCompletedView> responseEntity = this.testRestTemplate.exchange(
                "/api/v1/fresh-products/complete/1",
                HttpMethod.GET,
                request,
                BuyOrderCompletedView.class
        );

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }


}
