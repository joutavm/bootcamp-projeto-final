package com.mercadolibre.joao_magalhaes.integration;

import com.mercadolibre.joao_magalhaes.domain.dtos.form.InboundOrderForm;
import com.mercadolibre.joao_magalhaes.domain.dtos.view.StockView;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertBatchControllerTest extends ControllerTest{

    @Value("${jwt.expiration}")
    String expiration;

    @Value("${jwt.secret}")
    String secret;

    String token;



    @BeforeEach
    void setUp(){
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + Long.parseLong(expiration));

        token = Jwts.builder()
                .setIssuer("Frios API")
                .setSubject("1")
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    @Test
    void shouldReturnCreatedWhenPassValidForm() {
        InboundOrderForm orderForm = new InboundOrderForm();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", token);

        HttpEntity<InboundOrderForm> request = new HttpEntity<>(orderForm, headers);


        ResponseEntity<StockView> responseEntity = this.testRestTemplate.postForEntity(
                "/api/v1/fresh-products/inboundorder/",
                request,
                StockView.class
        );

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

}
