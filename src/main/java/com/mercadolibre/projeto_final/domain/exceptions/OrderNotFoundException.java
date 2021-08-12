package com.mercadolibre.projeto_final.domain.exceptions;

public class OrderNotFoundException extends ApiException {

    public OrderNotFoundException(String code, String description, Integer statusCode) {
        super(code, description, statusCode);
    }

}
